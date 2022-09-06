package com.hdhxby.ecommerce.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;

@Slf4j
public class RxJavaTest {

    @Test
    public void test1() throws JsonProcessingException {
        Observable.range(1, 3);
    }
}