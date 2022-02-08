package com.example.springwebsocket.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class ChannelInboundInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println("ChannelInboundInterceptor.preSend");
        System.out.println("message = " + message + ", channel = " + channel);
        return ChannelInterceptor.super.preSend(message, channel);
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        System.out.println("ChannelInboundInterceptor.postSend");
        System.out.println("message = " + message + ", channel = " + channel + ", sent = " + sent);
        ChannelInterceptor.super.postSend(message, channel, sent);
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        System.out.println("ChannelInboundInterceptor.afterSendCompletion");
        System.out.println("message = " + message + ", channel = " + channel + ", sent = " + sent + ", ex = " + ex);
        ChannelInterceptor.super.afterSendCompletion(message, channel, sent, ex);
    }

}
