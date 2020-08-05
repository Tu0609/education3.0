package com.education.lecturer.controller;


import com.education.lecturer.bean.Lecturer;
import com.education.lecturer.bean.LecturerAudit;
import com.education.lecturer.bean.to.LecturerAuditTO;
import com.education.lecturer.service.ILecturerAuditService;
import com.education.lecturer.service.ILecturerService;
import com.education.util.tools.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/user/pc/lecturer")
@Api(value = "讲师审核")
//@RequestMapping("/tcr.lecturer/lecturer-audit")
public class LecturerAuditController {

    @Autowired
    private ILecturerAuditService lecturerAuditService;

    @Autowired
    private ILecturerService lecturerService;

    @ApiOperation(value = "分页查询讲师审核信息")
    @PostMapping(value = "/audit/list")
    public ResultUtils getLecturerAuditPage(@RequestBody LecturerAuditTO lecturerAudit) {
        log.info("-------------------------------获取讲师审核信息---------------------------------");
        List<LecturerAudit> lecturerAuditPage = lecturerAuditService.getLecturerAuditPage(lecturerAudit);
        log.info("-----------------------------查询出来的结果：" + lecturerAuditPage);

        Map<String, Object> map = new HashMap<>();
        map.put("lecturerAudit", lecturerAuditPage);
        return ResultUtils.ok(map);
    }

    @ApiOperation(value = "更新讲师审核信息")
    @PutMapping(value = "/audit/update")
    public ResultUtils updateLecturerAudit(@RequestBody LecturerAudit lecturerAudit) {
        log.info("-------------------------------修改讲师审核信息---------------------------------");
        log.info("---------------------修改讲师审核信息：" + lecturerAudit);

        //判断是否修改审核状态
        if (lecturerAudit.getAuditStatus() != -1 && lecturerAudit.getAuditStatus() == 1) {

            if (lecturerAuditService.updateById(lecturerAudit)) {
                LecturerAudit lecturerAudits = lecturerAuditService.getById(lecturerAudit.getId());

                Lecturer lecturer = new Lecturer();
                lecturer.setStatusId(1); //状态
                lecturer.setLecturerUserNo(lecturerAudits.getLecturerUserNo()); //讲师的用户编号
                lecturer.setSort(lecturerAudits.getSort()); //排序
                lecturer.setLecturerName(lecturerAudits.getLecturerName()); //讲师名称
                lecturer.setLecturerMobile(lecturerAudits.getLecturerMobile()); //讲师号码
                lecturer.setLecturerEmail(lecturerAudits.getLecturerEmail()); //讲师邮箱
                lecturer.setPosition(lecturerAudits.getPosition()); //讲师职位
                lecturer.setHeadImgUrl(lecturerAudits.getHeadImgUrl()); //讲师头像
                lecturer.setIntroduce(lecturerAudits.getIntroduce()); //讲师简介
                lecturer.setLecturerProportion(lecturerAudits.getLecturerProportion()); //讲师分成

                boolean save = lecturerService.save(lecturer);

                return save ? ResultUtils.ok() : ResultUtils.error();
            }

        }

        Integer integer = lecturerAuditService.updateLecturer(lecturerAudit);
        return integer > 0 ? ResultUtils.ok() : ResultUtils.error();
    }

    @ApiOperation("新增讲师审核信息")
    @PutMapping("/audit/save")
    public ResultUtils insertLecturerAudit(@RequestBody LecturerAudit lecturerAudit) {

        log.info("-------------------------------新增讲师审核信息---------------------------------");
        log.info("---------------------修改讲师审核信息：" + lecturerAudit);

        boolean save = lecturerAuditService.save(lecturerAudit);
        return save ? ResultUtils.ok() : ResultUtils.error();
    }

}

