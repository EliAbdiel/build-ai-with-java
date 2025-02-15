package com.springai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class Config {

    @Value("classpath:input.txt")
    Resource resource;

    String input = """
            You are an AI assistant that specializes in {subject}.
            You respond in a {tone} voice with detailed explanations.
            """;

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        //return builder.defaultSystem(resource)
        //        .build();
        return builder.build();
    }
}
