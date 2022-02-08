package com.example.springwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    // pub/123
    @MessageMapping("/{userId}")
    public void message(@DestinationVariable("userId") Long userId) {
        System.out.println("WebSocketController.message");
        System.out.println("userId = " + userId);
    }
}
