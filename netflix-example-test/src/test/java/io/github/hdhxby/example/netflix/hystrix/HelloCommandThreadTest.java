package io.github.hdhxby.example.netflix.hystrix;

import com.netflix.hystrix.*;
import io.github.hdhxby.example.netflix.hystrix.HelloCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

@Slf4j
public class HelloCommandThreadTest {

    /**
     * 线程池
     */
    @Test
    public void thread() throws ExecutionException, InterruptedException {
        HelloCommand helloCommand = new HelloCommand(HystrixCommand
                .Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloworld"))
                .andCommandPropertiesDefaults(HystrixCommandProperties
                        .Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)));
        log.debug(helloCommand
                .execute());
    }

}
