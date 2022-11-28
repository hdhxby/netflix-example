package io.github.hdhxby.example.netflix.web.rest.impl;

import io.github.hdhxby.example.netflix.component.FooComponent;
import io.github.hdhxby.example.netflix.feign.WorldClient;
import io.github.hdhxby.example.netflix.web.rest.HelloResource;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class HelloResourceImpl implements HelloResource {

    private static final Logger logger = LoggerFactory.getLogger(HelloResourceImpl.class);

    private static final String WORD_API = "http://world/api/world";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WorldClient worldClient;

    @Autowired
    private FooComponent fooComponent;

    @Override
    public ResponseEntity<String> world(@RequestParam(value = "name",defaultValue = "world",required = false) String name,@RequestParam(value = "millis",defaultValue = "0",required = false) Long millis){
        return worldClient.world(name,millis);
    }

    @GetMapping("/rest")
    public ResponseEntity<String> rest(@RequestParam(value = "name",defaultValue = "world",required = false) String name, @RequestParam(value = "millis",defaultValue = "0",required = false) Long millis){
        return restTemplate.getForEntity(URI.create(String.format(WORD_API +"?name=%s&millis=%d",name,millis)),String.class);
    }

    @GetMapping("/foo")
    public ResponseEntity<String> foo(){
        return ResponseEntity.ok(fooComponent.getName());
    }
}
