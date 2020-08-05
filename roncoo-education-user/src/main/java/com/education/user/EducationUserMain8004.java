package com.education.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author TuTu
 * @date 2020/6/23 15:26
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.education.user.mapper")
@EnableFeignClients(basePackages = "com.education.user.service")
public class EducationUserMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(EducationUserMain8004.class);
    }

}
