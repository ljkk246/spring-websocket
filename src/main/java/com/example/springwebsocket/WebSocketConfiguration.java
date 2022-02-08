package com.example.springwebsocket;

import com.example.springwebsocket.handshake.WebSocketHandshakeHandler;
import com.example.springwebsocket.interceptor.ChannelInboundInterceptor;
import com.example.springwebsocket.interceptor.ChannelOutboundInterceptor;
import com.example.springwebsocket.interceptor.ExecutorInterceptor;
import com.example.springwebsocket.handshake.WebSocketHandshakeInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    private final ChannelInboundInterceptor channelInboundInterceptor;
    private final ChannelOutboundInterceptor channelOutboundInterceptor;
    private final ExecutorInterceptor executorInterceptor;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp")
                .addInterceptors(new WebSocketHandshakeInterceptor()).setHandshakeHandler(new WebSocketHandshakeHandler())
                .setAllowedOrigins("*");
        registry.addEndpoint("/ws-stomp")
                .addInterceptors(new WebSocketHandshakeInterceptor()).setHandshakeHandler(new WebSocketHandshakeHandler())
                .withSockJS();

    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(channelInboundInterceptor);
        registration.interceptors(executorInterceptor);
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.interceptors(channelOutboundInterceptor);
    }

}
