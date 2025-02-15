package com.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatOutputController {

    private final ChatClient chatClient;

    public ChatOutputController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/chat-json")
    public ResponseEntity<ChatResponse> chatJson(@RequestParam String message) {
        try {
            ChatResponse response = this.chatClient.prompt()
                    .user(message)
                    .call()
                    .chatResponse();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
