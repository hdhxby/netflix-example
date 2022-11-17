package io.github.hdhxby.example.hello.web.rest.impl;

import io.github.hdhxby.example.hello.web.rest.FooComponent;
import io.github.hdhxby.example.hello.web.rest.WorldResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WordResourceImpl implements WorldResource {

    @Autowired
    private FooComponent fooComponent;

    @GetMapping("/api/world")
    @Override
    public ResponseEntity<String> world(@RequestParam(value = "name",defaultValue = "world",required = false) String name,@RequestParam(value = "millis",defaultValue = "0",required = false) Long millis){
        if(millis < 0) {
            int i = 1/0;
        } else if(millis > 0){
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                // nothing.
            }
        }
        return ResponseEntity.ok(String.format("hello %s,sleep %d millis.", name, millis));
    }

    @GetMapping("/api/foo")
    public ResponseEntity<String> foo(@RequestParam(value = "name",defaultValue = "world",required = false) String name,@RequestParam(value = "millis",defaultValue = "0",required = false) Long millis){
        return ResponseEntity.ok(fooComponent.getName());
    }
}
