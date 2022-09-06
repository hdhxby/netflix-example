package com.hdhxby.ecommerce.zuul.config;

import com.hdhxby.ecommerce.zuul.ZuulFallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {

    @Bean
    public FallbackProvider fallbackProvider() {
        return new ZuulFallbackProvider();
    }
}
