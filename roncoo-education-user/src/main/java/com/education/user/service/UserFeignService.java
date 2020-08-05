package com.education.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/23 16:15
 */
@Component
@FeignClient(value = "nacos-education-sys")
public interface UserFeignService {

    @PostMapping("/education/feign/system/listMenu")
    public List<String> listMenuByUserID(@RequestParam("userID") Long userID);

}
