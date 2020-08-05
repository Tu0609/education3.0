package com.education.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.user.bean.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface IUserService extends IService<User> {

    //邮箱注册
    boolean insertByMail(User user);

    //验证邮箱验证码
    boolean activationMail(String mailNo, String code);

    //手机注册用户
    boolean insertUserByPhone(User user);

    //手机验证码验证
    boolean activation(String phone, String code);

}
