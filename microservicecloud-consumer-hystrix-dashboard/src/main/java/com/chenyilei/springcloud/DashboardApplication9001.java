package com.chenyilei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableHystrixDashboard
@EnableHystrix
public class DashboardApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication9001.class,args);
    }
}
