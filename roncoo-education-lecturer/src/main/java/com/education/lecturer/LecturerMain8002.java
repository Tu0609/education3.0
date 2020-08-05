package com.education.lecturer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TuTu
 * @date 2020/6/23 14:15
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.education.lecturer.mapper")
public class LecturerMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(LecturerMain8002.class);
    }

}
