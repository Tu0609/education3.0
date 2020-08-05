package com.education.user.controller;


import com.education.user.bean.UserExt;
import com.education.user.bean.to.UserTO;
import com.education.user.service.IUserExtService;
import com.education.util.tools.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class UserExtController {

    @Autowired
    private IUserExtService userExtService;

    /**
     *  根据条件分页查询学员信息
     * @param
     * @return
     */
    @PostMapping("/ext/list")
    public ResultUtils getStudentInfoPage(@RequestBody UserTO userTO) {
        log.info("----------------------查询学员列表-------------------------");
        List<UserExt> userInfo = userExtService.getStudentInfoPage(userTO);
        log.info("----------------学员信息：" + userInfo);

        Map<String, Object> map = new HashMap<>();
        map.put("userInfo", userInfo);

        return ResultUtils.ok(map);
    }

    /**
     *  修改学员信息
     * @param userExt
     * @return
     */
    @PutMapping("/ext/update")
    public Integer  updateStudent(@RequestBody UserExt userExt) {
        log.info("----------------------修改学员信息-------------------------");
        log.info("----------------修改信息：" + userExt);
        return userExtService.updateStudent(userExt);
    }
}

