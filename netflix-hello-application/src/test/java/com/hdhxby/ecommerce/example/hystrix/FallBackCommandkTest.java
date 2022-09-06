package com.hdhxby.ecommerce.example.hystrix;

import com.hdhxby.ecommerce.example.hystrix.FallBackCommand;
import com.netflix.hystrix.*;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class FallBackCommandkTest {

    @Test
    public void exception() throws ExecutionException, InterruptedException {
        assertEquals("fallback", new HystrixCommand(HystrixCommand
                .Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("exception")) ) {
            @Override
            protected Object run() throws Exception {
                int i = 1/0;
                return "run";
            }

            @Override
            protected Object getFallback() {
                return "fallback";
            }
        }.execute());
    }

    @Test
    public void thread() throws ExecutionException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Executors.newSingleThreadExecutor().submit(() -> {
            assertEquals("run", new HystrixCommand(HystrixCommand
                    .Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("threadpoll"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                            .withCoreSize(1)
                            .withQueueSizeRejectionThreshold(1))) {
                @Override
                protected Object run() throws Exception {
                    countDownLatch.countDown();
                    Thread.sleep(1000l);
                    return "run";
                }

                @Override
                protected Object getFallback() {
                    return "fallback";
                }
            }.execute());
        });
        countDownLatch.await();
        // 第一个请求占满链接,熔断
        assertEquals("fallback",new HystrixCommand(HystrixCommand
                .Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("threadpoll"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(1)
                        .withQueueSizeRejectionThreshold(1))) {
            @Override
            protected Object run() throws Exception {
                return "run";
            }

            @Override
            protected Object getFallback() {
                return "fallback";
            }
        }.execute());
    }

    @Test
    public void timeout() throws ExecutionException, InterruptedException {
        assertEquals("fallback", new HystrixCommand(HystrixCommand
                .Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("timeout"))
                .andCommandPropertiesDefaults(HystrixCommandProperties
                        .Setter()
                        .withExecutionTimeoutEnabled(true)
                        .withExecutionTimeoutInMilliseconds(100))) {
            @Override
            protected Object run() throws Exception {
                Thread.sleep(1000l);
                return "run";
            }

            @Override
            protected Object getFallback() {
                return "fallback";
            }
        }.execute());
    }

}
