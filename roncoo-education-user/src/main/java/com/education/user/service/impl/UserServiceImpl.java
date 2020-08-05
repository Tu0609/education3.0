package com.education.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.user.bean.User;
import com.education.user.config.SmsConfig;
import com.education.user.mapper.UserMapper;
import com.education.user.service.IUserService;
import com.education.user.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private MailService mailService;

    @Autowired
    private SmsConfig smsConfig;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     *  邮箱注册
     * @param user
     * @return
     */
    @Override
    public boolean insertByMail(User user) {

        int code = 0;

        if (baseMapper.insert(user) > 0) {
            int max = 9999;
            int min = 1111;

            code = new Random().nextInt(max%(max-min)+min);
            mailService.sendSimpleMail(user.getMobile(), "您的注册码", String.valueOf(code));
            stringRedisTemplate.opsForValue().set(user.getMobile().toString(), String.valueOf(code));
            return true;
        }

        return false;
    }

    /**
     *  邮箱认证
     * @param mailNo
     * @param code
     * @return
     */
    @Override
    public boolean activationMail(String mailNo, String code) {
        String redisCode = stringRedisTemplate.opsForValue().get(mailNo);
        return code.equals(redisCode) ? true : false;
    }

    /**
     *  手机注册
     * @param user
     * @return
     */
    @Override
    public boolean insertUserByPhone(User user) {

        int code = 0;

        if (baseMapper.insert(user) > 0) {
            int max = 9999;
            int min = 1111;
            code = new Random().nextInt(max%(max-min)+min);
            smsConfig.send(user.getMobile(), "1", new String[]{String.valueOf(code), "1"});
            stringRedisTemplate.opsForValue().set(user.getMobile().toString(), String.valueOf(code));
            return true;
        }

        return false;
    }

    /**
     *  手机认证
     * @param phone
     * @param code
     * @return
     */
    @Override
    public boolean activation(String phone, String code) {
        String redisCode = stringRedisTemplate.opsForValue().get(phone);
        return code.equals(redisCode) ? true : false;
    }
}
