package com.education.system.controller;

import com.education.system.bean.Website;
import com.education.system.service.IWebsiteService;
import com.education.util.tools.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 站点信息 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
@Slf4j
@RequestMapping(value = "/sys/pc")
@Api(value = "站点信息")
public class WebsiteController {

    @Autowired
    private IWebsiteService websiteService;

    @ApiOperation("获取站点信息")
    @GetMapping(value = "/website/view")
    public ResultUtils getWebsiteInfo() {
        log.info("--------------------------获取站点信息--------------------------");
        Website website = websiteService.getOne(null);
        log.info("---------------------站点信息：" + website);

        Map<String, Object> map = new HashMap<>();

        map.put("websiteinfo", website);

        return ResultUtils.ok(map);
    }

}

