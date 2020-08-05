package com.education.system.controller.feign;

import com.education.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/22 15:03
 */
@RestController
public class SysMenuFeignController {

    @Autowired
    private ISysMenuService sysMenuService;

    @PostMapping("/education/feign/system/listMenu")
    public List<String> listMenuByUserID(@RequestParam("userID") Long userID) {
        System.out.println("11111111112222222222");
        List<String> list = new ArrayList<>();

        if (userID == null) {
            return list;
        }

        List<String> menuList = sysMenuService.getMenuList(userID);

        return menuList;
    }

}
