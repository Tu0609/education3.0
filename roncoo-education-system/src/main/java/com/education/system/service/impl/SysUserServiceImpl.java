package com.education.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.system.bean.SysUser;
import com.education.system.mapper.SysUserMapper;
import com.education.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户信息 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

//    public SysUserCommon login(String username) {
//        //查询条件
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("mobile", username);
//
//        SysUser sysUser = baseMapper.selectOne(wrapper);
//
//        SysUserCommon userCommon = new SysUserCommon();
//
//        BeanUtils.copyProperties(sysUser, userCommon);
//
//        return userCommon;
//    }


}
