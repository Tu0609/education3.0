package com.education.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.user.bean.User;
import com.education.user.bean.to.LoginUserTO;
import com.education.user.bean.to.UserActivationTO;
import com.education.user.service.IUserService;
import com.education.user.service.UserFeignService;
import com.education.util.tools.JSONUtil;
import com.education.util.tools.JwtUtils;
import com.education.util.tools.ResultUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
@Slf4j
@RequestMapping("/user/pc/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserFeignService userFeignService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResultUtils login(@RequestBody LoginUserTO loginUser) {
        log.info("--------------------------------用户登录-------------------------------");
        //查询用户名或密码是否正确
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("mobile", loginUser.getUsername());
        wrapper.eq("mobile_psw", loginUser.getPassword());
        User user = userService.getOne(wrapper);
        log.info("------------------------用户信息：" + user);
        if (user == null) {
            return ResultUtils.error();
        }
        //根据用户ID查询菜单信息
        List<String> menuList = userFeignService.listMenuByUserID(user.getId());
        log.info("------------------------菜单信息：" + menuList);
        String token =  JwtUtils.getJwtToken(user.getId().toString(), user.getMobile());
        log.info("------------------------token：" + token);
        stringRedisTemplate.opsForValue().set(token, JSONUtil.toJSONString(menuList));
        log.info("------------------------存入redis的权限信息：" + JSONUtil.toJSONString(menuList));

        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        return ResultUtils.ok(map);
    }

    @PostMapping(value = "/insertUserExt")
    @ApiOperation(value = "注册用户信息")
    public ResultUtils insertUserExt(@ApiParam(value = "用户信息") @RequestBody User user) {
        boolean bool = userService.insertUserByPhone(user);
        return bool ? ResultUtils.ok() : ResultUtils.error();
    }

    @PostMapping(value = "/activationPhone")
    @ApiOperation(value = "检验验证码是否正确")
    public ResultUtils activationPhone(@ApiParam(value = "验证信息") @RequestBody UserActivationTO userActivationTO) {
        System.out.println("用户手机号码：" + userActivationTO.getPhone());
        boolean activation = userService.activation(userActivationTO.getPhone(), userActivationTO.getCode());
        return activation ? ResultUtils.ok() : ResultUtils.error();
    }

    @PostMapping(value = "/activationMail")
    @ApiOperation(value = "通过邮箱注册")
    public ResultUtils insertUserExtMail(@ApiParam(value = "通过邮箱注册用户") @RequestBody User user) {
        boolean bool = userService.insertByMail(user);
        return bool ? ResultUtils.ok() : ResultUtils.error();
    }

    @PostMapping(value = "/activationMailNo")
    @ApiOperation(value = "检验验证码是否正确")
    public ResultUtils activationMailNo(@ApiParam(value = "验证信息") @RequestBody UserActivationTO userActivationTO) {
        System.out.println("用户邮箱：" + userActivationTO.getPhone());
        boolean activation = userService.activationMail(userActivationTO.getPhone(), userActivationTO.getCode());
        return activation ? ResultUtils.ok() : ResultUtils.error();
    }

}

