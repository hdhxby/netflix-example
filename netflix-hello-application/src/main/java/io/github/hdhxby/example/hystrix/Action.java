package io.github.hdhxby.example.hystrix;

@FunctionalInterface
public interface Action<R> {
    R apply();
}
