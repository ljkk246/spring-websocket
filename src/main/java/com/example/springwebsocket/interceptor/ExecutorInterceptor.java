package com.example.springwebsocket.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.ExecutorChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class ExecutorInterceptor implements ExecutorChannelInterceptor {
    @Override
    public Message<?> beforeHandle(Message<?> message, MessageChannel channel, MessageHandler handler) {
        System.out.println("ExecutorInterceptor.beforeHandle");
        System.out.println("message = " + message + ", channel = " + channel + ", handler = " + handler);
        return ExecutorChannelInterceptor.super.beforeHandle(message, channel, handler);
    }

    @Override
    public void afterMessageHandled(Message<?> message, MessageChannel channel, MessageHandler handler, Exception ex) {
        System.out.println("ExecutorInterceptor.afterMessageHandled");
        System.out.println("message = " + message + ", channel = " + channel + ", handler = " + handler + ", ex = " + ex);
        ExecutorChannelInterceptor.super.afterMessageHandled(message, channel, handler, ex);
    }
}
