package com.education.lecturer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.lecturer.bean.LecturerAudit;
import com.education.lecturer.bean.to.LecturerAuditTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface ILecturerAuditService extends IService<LecturerAudit> {

    public List<LecturerAudit> getLecturerAuditPage(LecturerAuditTO lecturerAudit);

    public Integer updateLecturer(LecturerAudit lecturerAudit);
}
