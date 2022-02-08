package com.example.springwebsocket.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
public class ConnectionListener implements ApplicationListener<SessionConnectEvent> {

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        System.out.println("ConnectionListener.onApplicationEvent");
        System.out.println("event = " + event);
    }
}
