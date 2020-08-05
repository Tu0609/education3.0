package com.education.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.user.bean.UserExt;
import com.education.user.bean.to.UserTO;
import com.education.user.mapper.UserExtMapper;
import com.education.user.service.IUserExtService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class UserExtServiceImpl extends ServiceImpl<UserExtMapper, UserExt> implements IUserExtService {

    /**
     *  根据条件分页查询学员信息
     * @param
     * @return
     */
    @Override
    public List<UserExt> getStudentInfoPage(UserTO userTO) {

        Page page = new Page(userTO.getCurrend(), userTO.getLimit());

        //查询条件
        QueryWrapper queryWrapper = new QueryWrapper();

        if (userTO.getMobile() != null) {
            queryWrapper.eq("mobile",userTO.getMobile());
        }

        if (userTO.getNickname() != null) {
            queryWrapper.like("nickname",userTO.getNickname());
        }

        if (userTO.getStatusId() != -1) {
            queryWrapper.eq("statuc_id",userTO.getStatusId());
        }

        if (userTO.getCreateTime() != null && userTO.getEndTime() != null) {
            queryWrapper.between("gmt_create", userTO.getCreateTime(), userTO.getEndTime());
        }

        IPage iPage = baseMapper.selectPage(page, queryWrapper);

        return iPage.getRecords();
    }

    /**
     *  修改学员信息
     * @param userExt
     * @return
     */
    @Override
    public Integer updateStudent(UserExt userExt) {

//        QueryWrapper wrapper = new QueryWrapper();
//
//        if (userExt.getMobile() != null) {
//            wrapper.eq("mobile",  userExt.getMobile());
//        }
//
//        if (userExt.getNickname() != null) {
//            wrapper.like("nickname", userExt.getNickname());
//        }
//
//        if (userExt.getStatusId() != -1) {
//            wrapper.eq("status_id", userExt.getStatusId());
//        }
//
//        if (userExt.getRemark() != null) {
//            wrapper.eq("remark", userExt.getRemark());
//        }
//
//        wrapper.eq("sex", userExt.getSex());
//        wrapper.eq("age",userExt.getAge());

        int update = baseMapper.updateById(userExt);

        return update;
    }
}
