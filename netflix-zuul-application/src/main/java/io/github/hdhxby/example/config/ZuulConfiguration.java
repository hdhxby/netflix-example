package io.github.hdhxby.example.config;

import github.hdhxby.example.zuul.ZuulFallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Zuul配置
 * @author lixiaobin
 */
@Configuration
public class ZuulConfiguration {

    @Bean
    public FallbackProvider fallbackProvider() {
        return new ZuulFallbackProvider();
    }
}