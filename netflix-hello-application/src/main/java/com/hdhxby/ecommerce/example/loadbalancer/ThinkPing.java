package com.hdhxby.ecommerce.example.loadbalancer;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class ThinkPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        return true;
    }
}
