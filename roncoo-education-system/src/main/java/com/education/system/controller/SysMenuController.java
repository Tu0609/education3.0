package com.education.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单信息 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@RestController
@Slf4j
@RequestMapping(value = "/sys/pc")
public class SysMenuController {

    @GetMapping("/payment/get/list")
    public String test() {
        return "index";
    }


}

