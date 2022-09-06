package com.hdhxby.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 网关(zuul)
 * @author lixiaobin
 * @version 2.0.0
 * @since 2.0.0
 */
@EnableConfigServer
//@EnableDiscoveryClient
//@SpringCloudApplication
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}