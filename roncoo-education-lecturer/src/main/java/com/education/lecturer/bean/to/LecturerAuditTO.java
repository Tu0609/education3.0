package com.education.lecturer.bean.to;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author TuTu
 * @date 2020/6/18 15:32
 */
@Data
@ApiModel(value="讲师查询信息", description="")
public class LecturerAuditTO {

    private String lecturerName;

    private String lecturerMobile;

    private Integer statusId;

    private Integer auditStatus;

    private Integer currend;

    private Integer limit;
}
