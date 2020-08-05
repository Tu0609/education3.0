package com.education.course.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程信息-审核
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CourseAudit对象", description="课程信息-审核")
public class CourseAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "状态(1:正常，0:禁用)")
    private Integer statusId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "审核状态(0:待审核,1:审核通过,2:审核不通过)")
    private Integer auditStatus;

    @ApiModelProperty(value = "审核意见")
    private String auditOpinion;

    @ApiModelProperty(value = "讲师用户编码")
    private Long lecturerUserNo;

    @ApiModelProperty(value = "一级分类ID")
    private Long categoryId1;

    @ApiModelProperty(value = "二级分类ID")
    private Long categoryId2;

    @ApiModelProperty(value = "三级分类ID")
    private Long categoryId3;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "课程封面")
    private String courseLogo;

    @ApiModelProperty(value = "课程介绍ID")
    private Long introduceId;

    @ApiModelProperty(value = "是否免费：1免费，0收费")
    private Integer isFree;

    @ApiModelProperty(value = "原价")
    private BigDecimal courseOriginal;

    @ApiModelProperty(value = "优惠价")
    private BigDecimal courseDiscount;

    @ApiModelProperty(value = "是否上架(1:上架，0:下架)")
    private Integer isPutaway;


}
