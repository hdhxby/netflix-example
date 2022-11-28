package io.github.hdhxby.example.netflix.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 获取一条数据
 */
@Slf4j
//@Component
public class HelloCommand extends HystrixCommand<String> {

    public HelloCommand() {
        this("helloCommandGroup");
    }

    public HelloCommand(String key){
        super(HystrixCommandGroupKey.Factory.asKey(key));
    }

    public HelloCommand(Setter setter) {
        super(setter);
    }

    /**
     * 降级
     * @return
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        log.debug("run");
        return "hello";
    }

}
