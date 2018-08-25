package com.chenyilei.springcloud;

import com.chenyilei.irule.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name ="MICROSERVICECLOUD-DEPT",configuration =config.class)
@EnableCircuitBreaker
public class ConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80Application.class, args);
    }
}
