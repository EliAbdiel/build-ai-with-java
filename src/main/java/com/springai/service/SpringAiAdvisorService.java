package com.springai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SpringAiAdvisorService {

    private final ChatClient chatClient;

    public SpringAiAdvisorService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public ResponseEntity<String> getResponse(String message) {
        try {
            var response = chatClient.prompt()
                    .user(message)
                    .call()
                    .content();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
