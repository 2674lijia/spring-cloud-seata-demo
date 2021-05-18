package com.example.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.example.consume")
@EnableFeignClients(basePackages = "com.example.feignclient")
@EnableDiscoveryClient
@EnableEurekaClient
public class ConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }

}
