package com.education.order.controller;

import com.education.order.config.RabbitConfig;
import com.education.util.tools.JwtUtils;
import com.education.util.tools.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TuTu
 * @date 2020/6/28 10:36
 */
@RestController
@Slf4j
public class CourseSecondsKillController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/seconds")
    public synchronized ResultUtils secondsKill(HttpServletRequest request) {

        String userNo = JwtUtils.getMemberIdByJwtToken(request.getHeader("token"));

        String number = stringRedisTemplate.opsForValue().get("kucun");

        if (Integer.parseInt(number) <= 0) {
            log.info("---------------------商品已经抢购完成！");
            return ResultUtils.error();
        } else {
            int newNumber = Integer.parseInt(number) - 1;
            //更新redis的库存
            stringRedisTemplate.opsForValue().set("kucun", String.valueOf(newNumber));
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,"1");
        }
        return ResultUtils.ok();
    }

}
