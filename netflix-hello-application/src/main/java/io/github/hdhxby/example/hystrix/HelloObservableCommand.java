package io.github.hdhxby.example.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * 获取多条数据
 */
@Slf4j
public class HelloObservableCommand extends HystrixObservableCommand<String> {

    private RestTemplate restTemplate = new RestTemplate();

    public HelloObservableCommand(){
        this("helloObservableCommandGroup");
    }

    public HelloObservableCommand(String key){
        super(HystrixCommandGroupKey.Factory.asKey(key));
    }

    public HelloObservableCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                log.debug("call");
                 subscriber.onNext("hello");
                 subscriber.onNext("world");
                 subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }

}
