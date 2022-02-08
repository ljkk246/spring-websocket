package com.example.springwebsocket.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class SubscribeListener implements ApplicationListener<SessionSubscribeEvent> {
    @Override
    public void onApplicationEvent(SessionSubscribeEvent event) {
        System.out.println("SubscribeListener.onApplicationEvent");
        System.out.println("event = " + event);
    }
}
