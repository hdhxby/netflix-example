package io.github.hdhxby.example;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
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
@EnableFeignClients
@EnableDiscoveryClient
//@SpringBootApplication
@SpringCloudApplication
public class NetflixHelloApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NetflixHelloApplication.class);
        springApplication.setHeadless(false);
        springApplication.run(args);
    }
}
