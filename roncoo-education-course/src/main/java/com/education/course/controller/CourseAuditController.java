package com.education.course.controller;


import com.education.course.bean.Course;
import com.education.course.bean.CourseAudit;
import com.education.course.bean.to.CourseAuditTO;
import com.education.course.service.ICourseAuditService;
import com.education.course.service.ICourseService;
import com.education.util.tools.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程信息-审核 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
//@RequestMapping("/tcr.course/course-audit")
@Slf4j
public class CourseAuditController {

    @Autowired
    private ICourseAuditService courseAuditService;

    @Autowired
    private ICourseService courseService;
    /**
     *  获取课程审核信息
     * @param courseAudit
     * @return
     */
    @PostMapping(value = "/course/pc/course/audit/list")
    public ResultUtils getCourseAuditPage(@RequestBody CourseAuditTO courseAudit) {
        log.info("--------------------------获取课程审核信息------------------------------");
        log.info("------------------------查询条件：" + courseAudit);
        List<CourseAudit> courseAuditPage = courseAuditService.getCourseAuditPage(courseAudit);
        log.info("------------------------查询出的数据：" + courseAuditPage);

        Map<String, Object> map = new HashMap<>();
        map.put("course", courseAuditPage);

        return ResultUtils.ok(map);
    }

    /**
     *  更新课程审核信息
     * @param courseAudit
     * @return
     */
    @PutMapping(value = "/course/pc/adv/update")
    public ResultUtils updateCourseAudit(@RequestBody CourseAudit courseAudit) {
        log.info("--------------------------更新课程审核信息------------------------------");
        log.info("------------------------更新审核信息：" + courseAudit);

        if (courseAudit.getAuditStatus() != -1 && courseAudit.getAuditStatus() == 1) {

            if (courseAuditService.updateCourseAudit(courseAudit) > 0) {

                CourseAudit courseAudits = courseAuditService.getById(courseAudit.getId());

                Course course = new Course();
                BeanUtils.copyProperties(courseAudits, course);

                return courseService.save(course) ? ResultUtils.ok() : ResultUtils.error();
            }

        }

        Integer integer = courseAuditService.updateCourseAudit(courseAudit);
        return integer > 0 ? ResultUtils.ok() : ResultUtils.error();
    }

    @PutMapping("/course/pc/adv/save")
    public ResultUtils insertCourseAudit(@RequestBody CourseAudit courseAudit) {
        log.info("--------------------------更新课程审核信息------------------------------");
        log.info("------------------------更新审核信息：" + courseAudit);
        boolean save = courseAuditService.save(courseAudit);
        return save ? ResultUtils.ok() : ResultUtils.error();
    }

}

