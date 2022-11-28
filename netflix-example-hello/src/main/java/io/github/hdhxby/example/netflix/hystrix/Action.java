package io.github.hdhxby.example.netflix.hystrix;

@FunctionalInterface
public interface Action<R> {
    R apply();
}
