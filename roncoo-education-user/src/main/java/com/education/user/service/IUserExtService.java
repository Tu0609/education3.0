package com.education.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.user.bean.UserExt;
import com.education.user.bean.to.UserTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface IUserExtService extends IService<UserExt> {

    public List<UserExt> getStudentInfoPage(UserTO userTO);

    public Integer updateStudent(UserExt userExt);

}
