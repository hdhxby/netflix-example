package io.github.hdhxby.example.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 权限中心
 *
 * @author lixiaobin
 * @version 2.0, 03/06/21
 * @since 2.0
 */
@EnableHystrix
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringCloudApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(HelloApplication.class);
        springApplication.setHeadless(false);
        springApplication.run(args);
    }
}
