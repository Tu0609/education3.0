package com.education.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author TuTu
 * @date 2020/6/23 15:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.education.order.mapper")
@EnableFeignClients
public class EducationOrderMain8003 {

    public static void main(String[] args) {
        SpringApplication.run(EducationOrderMain8003.class);
    }

}
