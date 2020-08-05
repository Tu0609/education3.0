package com.education.gateway;

//import com.education.gateway.filter.FilterPre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TuTu
 * @date 2020/6/22 19:27
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableSwagger2
public class GatewayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class);
    }

}
