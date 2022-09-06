package com.hdhxby.ecommerce.example.web.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@ServerEndpoint("/api/example/ws")
@Component
public class WSResource {

    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    @OnOpen
    public void onOpen(Session session){
        log.debug("onOpen");
    }


    @OnMessage
    public void onMessage(String words,Session session){
        log.debug(words);
        session.getAsyncRemote().sendText("word");
        executorService.schedule(()-> {
            session.getAsyncRemote().sendText("hello");
        },1000, TimeUnit.MILLISECONDS);
    }


    @OnError
    public void onError(Session session, Throwable e){
        log.debug("onError");

    }


    @OnClose
    public void onClose(Session session){
        log.debug("onClose");

    }
}
