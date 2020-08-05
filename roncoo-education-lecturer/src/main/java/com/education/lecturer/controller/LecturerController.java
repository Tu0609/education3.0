package com.education.lecturer.controller;


import com.education.lecturer.bean.Lecturer;
import com.education.lecturer.bean.to.LecturerTO;
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
@RequestMapping("/user/pc/lecturer")
@Slf4j
@Api(value = "讲师信息")
public class LecturerController {

    @Autowired
    private ILecturerService lecturerService;

    /**
     *  根据条件分页查询讲师信息
     *
     * @param queryLecturer
     * @return
     */
    @ApiOperation(value = "分页查询讲师信息")
    @PostMapping("/list")
    public ResultUtils getLecturerPage(@RequestBody LecturerTO queryLecturer) {
        log.info("--------------------查询讲师信息-----------------------------");
        List<Lecturer> lecturerPage = lecturerService.getLecturerPage(queryLecturer);
        log.info("---------------------查询到的信息：" + lecturerPage);
        Map<String, Object>  map = new HashMap<>();
        map.put("lecturer", lecturerPage);
        return ResultUtils.ok(map);
    }

    /**
     *  更新讲师信息
     * @param lecturer
     * @return
     */
    @ApiOperation(value = "更新讲师信息")
    @PutMapping("/update")
    public ResultUtils updateLecturer(@RequestBody Lecturer lecturer) {
        log.info("--------------------修改讲师信息-----------------------------");
        log.info("--------------------------修改信息：" + lecturer);
        Integer integer = lecturerService.updateLecturer(lecturer);
        return integer > 0 ? ResultUtils.ok() : ResultUtils.error();
    }

}

