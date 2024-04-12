package com.example.OneToOneChat.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public void registerStompEndPoints(StompEndpointRegistry registry){
        registry.addEndpoint("/chat") // socket 연결 url
                .setAllowedOriginPatterns("*");// CORS 허용 범위
    }

    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/topic"); // 구독 url
        registry.setApplicationDestinationPrefixes("/app"); // prefix 정의
    }
}
