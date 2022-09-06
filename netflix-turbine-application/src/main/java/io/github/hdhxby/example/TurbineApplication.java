package io.github.hdhxby.example;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * hystrix-dashboard
 * @author lixiaobin
 * @version 2.0.0
 * @since 2.0.0
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringCloudApplication
public class TurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }
}
