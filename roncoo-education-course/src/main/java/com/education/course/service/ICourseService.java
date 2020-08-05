package com.education.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.course.bean.Course;
import com.education.course.bean.to.CourseTO;

import java.util.List;

/**
 * <p>
 * 课程信息 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface ICourseService extends IService<Course> {

    public List<Course> getCoursePage(CourseTO courseTO);

    public Integer updateCourse(Course course);

    public List getElasticSearchInfo(CourseTO courseTO);
}
