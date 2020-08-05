package com.education.order.bean;

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
 * 订单信息表
 * </p>
 *
 * @author Tutu
 * @since 2020-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderInfo对象", description="订单信息表")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "讲师用户编号")
    private Long lecturerUserNo;

    @ApiModelProperty(value = "讲师名称")
    private String lecturerName;

    @ApiModelProperty(value = "用户编号")
    private Long userNo;

    @ApiModelProperty(value = "用户电话")
    private String mobile;

    @ApiModelProperty(value = "用户注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "订单号")
    private Long orderNo;

    @ApiModelProperty(value = "课程ID")
    private Long courseId;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "应付金额")
    private BigDecimal pricePayable;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal priceDiscount;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal pricePaid;

    @ApiModelProperty(value = "平台收入")
    private BigDecimal platformProfit;

    @ApiModelProperty(value = "讲师收入")
    private BigDecimal lecturerProfit;

    @ApiModelProperty(value = "交易类型：1线上支付，2线下支付")
    private Integer tradeType;

    @ApiModelProperty(value = "支付方式：1微信支付，2支付宝支付")
    private Integer payType;

    @ApiModelProperty(value = "购买渠道：1web")
    private Integer channelType;

    @ApiModelProperty(value = "订单状态：1待支付，2成功支付，3支付失败，4已关闭")
    private Integer orderStatus;

    @ApiModelProperty(value = "是否显示给讲师(1是，0否)")
    private Integer isShowLecturer;

    @ApiModelProperty(value = "是否显示给用户看(1是，0否)")
    private Integer isShowUser;

    @ApiModelProperty(value = "客户备注")
    private String remarkCus;

    @ApiModelProperty(value = "后台备注")
    private String remark;

    @ApiModelProperty(value = "支付时间")
    private LocalDateTime payTime;

}
