package com.hdhxby.ecommerce.example.config;

import com.hdhxby.ecommerce.example.loadbalancer.ThinkPing;
import com.hdhxby.ecommerce.example.loadbalancer.ThinkRule;
import com.netflix.loadbalancer.ILoadBalancer;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Bean
    public ThinkRule thinkRule(ILoadBalancer loadBalancer){
        return new ThinkRule(loadBalancer);
    }

    @Bean
    public ThinkPing thinkPing(){
        return new ThinkPing();
    }
}
