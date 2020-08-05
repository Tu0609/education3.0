package com.education.system.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 站点信息
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Website对象", description="站点信息")
public class Website implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "状态(1有效, 0无效)")
    private Integer statusId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "org_logo_ico")
    private String logoIco;

    @ApiModelProperty(value = "org_logo_img")
    private String logoImg;

    @ApiModelProperty(value = "站点标题")
    private String websiteTitle;

    @ApiModelProperty(value = "站点关键词")
    private String websiteKeyword;

    @ApiModelProperty(value = "站点描述")
    private String websiteDesc;

    @ApiModelProperty(value = "站点版权")
    private String copyright;

    @ApiModelProperty(value = "备案号")
    private String icp;

    @ApiModelProperty(value = "公安备案号")
    private String prn;

    @ApiModelProperty(value = "站点微信")
    private String weixin;

    @ApiModelProperty(value = "小程序二维码")
    private String weixinXcx;

    @ApiModelProperty(value = "站点微博")
    private String weibo;

    @ApiModelProperty(value = "是否开启统计")
    private Integer isEnableStatistics;

    @ApiModelProperty(value = "统计代码")
    private String statisticsCode;

    @ApiModelProperty(value = "是否显示客服信息")
    private Integer isShowService;

    @ApiModelProperty(value = "客服信息1")
    private String service1;

    @ApiModelProperty(value = "客服信息2")
    private String service2;

    @ApiModelProperty(value = "用户协议")
    private String userAgreement;

    @ApiModelProperty(value = "招募标题")
    private String recruitTitle;

    @ApiModelProperty(value = "招募信息")
    private String recruitInfo;

    @ApiModelProperty(value = "入驻协议")
    private String entryAgreement;


}
