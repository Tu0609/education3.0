package com.education.lecturer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.lecturer.bean.Lecturer;
import com.education.lecturer.bean.to.LecturerTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface ILecturerService extends IService<Lecturer> {

    public List<Lecturer> getLecturerPage(LecturerTO lecturerTO);

    public Integer updateLecturer(Lecturer lecturer);
}
