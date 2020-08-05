package com.education.user.bean.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "验证用户码")
@Data
public class UserActivationTO {

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "验证码")
    private String code;

}
