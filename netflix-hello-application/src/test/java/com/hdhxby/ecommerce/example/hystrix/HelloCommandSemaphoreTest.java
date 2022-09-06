package com.hdhxby.ecommerce.example.hystrix;

import com.hdhxby.ecommerce.example.hystrix.HelloCommand;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class HelloCommandSemaphoreTest {

    /**
     * 信号量
     */
    @Test
    public void semaphore() throws ExecutionException, InterruptedException {
        HelloCommand helloCommand = new HelloCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloCommandGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties
                        .Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(10)));
        log.debug(helloCommand
                .execute());
    }

}
