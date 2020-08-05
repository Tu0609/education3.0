package com.education.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.course.bean.CourseAudit;
import com.education.course.bean.to.CourseAuditTO;

import java.util.List;

/**
 * <p>
 * 课程信息-审核 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface ICourseAuditService extends IService<CourseAudit> {

    public List<CourseAudit> getCourseAuditPage(CourseAuditTO courseAuditTO);

    public Integer updateCourseAudit(CourseAudit courseAudit);
}
