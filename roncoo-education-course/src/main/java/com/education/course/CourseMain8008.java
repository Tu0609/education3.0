package com.education.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TuTu
 * @date 2020/6/26 9:24
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.education.course.mapper")
public class CourseMain8008 {

    public static void main(String[] args) {
        SpringApplication.run(CourseMain8008.class);
    }

}
