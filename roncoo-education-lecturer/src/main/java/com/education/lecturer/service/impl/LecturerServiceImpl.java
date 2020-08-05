package com.education.lecturer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.lecturer.bean.Lecturer;
import com.education.lecturer.bean.to.LecturerTO;
import com.education.lecturer.mapper.LecturerMapper;
import com.education.lecturer.service.ILecturerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class LecturerServiceImpl extends ServiceImpl<LecturerMapper, Lecturer> implements ILecturerService {

    /**
     *  根据条件分页查询教师信息
     * @param
     * @return
     */
    @Override
    public List<Lecturer> getLecturerPage(LecturerTO lecturerTO) {

        Page page = new Page(lecturerTO.getCurrend(), lecturerTO.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (lecturerTO.getLecturerName() != null) {
            wrapper.like("lecturer_name",lecturerTO.getLecturerName());
        }

        if (lecturerTO.getLecturerMobile() != null) {
            wrapper.eq("lecturer_mobile",lecturerTO.getLecturerMobile());
        }

        IPage list = baseMapper.selectPage(page,wrapper);

        return list.getRecords();
    }

    @Override
    public Integer updateLecturer(Lecturer lecturer) {
        return baseMapper.updateById(lecturer);
    }
}
