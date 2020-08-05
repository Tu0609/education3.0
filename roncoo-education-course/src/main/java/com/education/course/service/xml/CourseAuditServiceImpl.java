package com.education.course.service.xml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.course.bean.CourseAudit;
import com.education.course.bean.to.CourseAuditTO;
import com.education.course.mapper.CourseAuditMapper;
import com.education.course.service.ICourseAuditService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程信息-审核 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class CourseAuditServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements ICourseAuditService {

    /**
     *  获取课程审核信息
     * @param courseAudit
     * @return
     */
    @Override
    public List<CourseAudit> getCourseAuditPage(CourseAuditTO courseAudit) {

        Page page = new Page(courseAudit.getCurrend(), courseAudit.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (courseAudit.getCourseName() != null) {
            wrapper.like("course_name", courseAudit.getCourseName());
        }

        if (courseAudit.getStatusId() != -1) {
            wrapper.eq("status_id", courseAudit.getStatusId());
        }

        if (courseAudit.getIsFree() != -1) {
            wrapper.eq("is_free", courseAudit.getIsFree());
        }

        if (courseAudit.getIsPutaway() != -1) {
            wrapper.eq("is_putaway", courseAudit.getIsPutaway());
        }

        if (courseAudit.getAuditStatus() != -1) {
            wrapper.eq("audit_status", courseAudit.getAuditStatus());
        }

        IPage iPage = baseMapper.selectPage(page, wrapper);

        return iPage.getRecords();
    }

    /**
     *  更新课程审核信息
     * @param courseAudit
     * @return
     */
    @Override
    public Integer updateCourseAudit(CourseAudit courseAudit) {
        return baseMapper.updateById(courseAudit);
    }
}
