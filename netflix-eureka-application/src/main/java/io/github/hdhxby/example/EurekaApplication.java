package io.github.hdhxby.example;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心(eureka)
 * @author lixiaobin
 * @version 2.0.0
 * @since 2.0.0
 */
@EnableEurekaServer
@SpringCloudApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
