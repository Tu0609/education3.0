package com.education.order.service.xml;

import com.education.order.bean.Secondskillorder;
import com.education.order.config.RabbitConfig;
import com.education.order.service.ICourseinventoryService;
import com.education.order.service.ISecondskillorderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecondsKillServiceImpl {

    @Autowired
    private ICourseinventoryService courseinventoryService;

    @Autowired
    private ISecondskillorderService secondskillorderService;

    @RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void insertOrder(String userNo) {
        log.info("-------------------------------队列中的用户ID：" + userNo);
        System.out.println(123);
        boolean b = courseinventoryService.updateInventory(Long.valueOf(1));
        Secondskillorder secondskillorder = new Secondskillorder();
        secondskillorder.setPrice(18);
        secondskillorder.setCourseId(1);
        secondskillorder.setStatusId(0);
        secondskillorder.setUserId(1);
        secondskillorderService.save(secondskillorder);
    }


}
