package com.hdhxby.ecommerce.example.hystrix;

@FunctionalInterface
public interface Action<R> {
    R apply();
}
