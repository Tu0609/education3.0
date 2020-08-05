package com.education.order.bean.to;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author TuTu
 * @date 2020/6/19 11:34
 */
@Data
public class OrderTO {

    private String mobile;

    private String courseName;

    private Integer orderStatus;

    private Long orderNo;

    private String lecturerName;

    private String remark;

    private Integer channelType;

    private Integer payType;

    private LocalDateTime createTime;

    private LocalDateTime endTime;

    private Integer currend;

    private Integer limit;
}
