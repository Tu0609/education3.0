package com.education.course.bean.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author TuTu
 * @date 2020/6/19 8:10
 */
@Data
@ApiModel(value="查询课程信息", description="课程信息")
public class CourseAuditTO {

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "状态(1:正常，0:禁用)")
    private Integer statusId;

    @ApiModelProperty(value = "是否免费：1免费，0收费")
    private Integer isFree;

    @ApiModelProperty(value = "是否上架(1:上架，0:下架)")
    private Integer isPutaway;

    @ApiModelProperty(value = "审核状态(0:待审核,1:审核通过,2:审核不通过)")
    private Integer auditStatus;

    @ApiModelProperty(value = "当前页")
    private Integer currend;

    @ApiModelProperty(value = "显示条数")
    private Integer limit;

}
