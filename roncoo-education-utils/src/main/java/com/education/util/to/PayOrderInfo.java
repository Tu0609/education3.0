package com.education.util.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author TuTu
 * @date 2020/6/24 10:45
 */
@Data
@ApiModel(value="订单支付", description="")
public class PayOrderInfo {

    private Integer courseId;

    @ApiModelProperty(value = "订单号")
    private Long orderNo;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal pricePaid;


}
