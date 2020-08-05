package com.education.course.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.education.course.bean.Course;
import com.education.course.bean.to.CourseTO;
import com.education.course.service.ICourseService;
import com.education.util.tools.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程信息 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
@Slf4j
//@RequestMapping("/tcr.course/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    /**
     *  根据条件分页查询课程信息
     * @param queryCourse
     * @return
     */
    @PostMapping(value = "/courses/pc/course/list")
    @SentinelResource(value = "courses/pc/course/list", blockHandler = "exceptionHandler")
    public ResultUtils getCoursePage(@RequestBody CourseTO queryCourse) {
        log.info("------------------------查询课程信息----------------------------");
        List<Course> coursePage = courseService.getCoursePage(queryCourse);
        log.info("-------------------课程信息：" + coursePage);

        Map<String, Object> map = new HashMap<>();
        map.put("course", coursePage);

        return ResultUtils.ok(map);
    }

    public ResultUtils exceptionHandler(BlockException block) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "熔断兜底的方法！");
        log.info("熔断兜底的方法！");
        return ResultUtils.error();
    }

    /**
     *  更新课程信息
     * @param course
     * @return
     */
    @PutMapping(value = "/courses/pc/course/update")
    public ResultUtils updateCourse(@RequestBody Course course) {
        log.info("------------------------更新课程信息----------------------------");
        log.info("-------------------条件信息：" + course);
        Integer integer = courseService.updateCourse(course);
        return integer > 0 ? ResultUtils.ok() : ResultUtils.error();
    }

    /**
     *  根据ElasticSearch
     * @param course
     * @return
     */
    @GetMapping("/course/pc/get")
    public ResultUtils getElasticSearchInfo(@RequestBody CourseTO course) {
        Map<String, Object> map = new HashMap<>();
        map.put("course", courseService.getElasticSearchInfo(course));
        return ResultUtils.ok(map);
    }

}

