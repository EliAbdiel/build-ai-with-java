package com.springai.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    Logger logger = LoggerFactory.getLogger(ChatService.class);

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ResponseEntity<String> generateChatResponse(String subject, String tone, String message) {
        logger.info("Generating chat response from ChatService");
        try {
            var result = chatClient
                    //.prompt(new Prompt("The Fibonacci Number Algorithm"))
                    .prompt()
                    .system(sp -> sp
                            .param("subject", subject)
                            .param("tone", tone)
                    )
                    .user(message)
                    .call()
                    .chatResponse()
                    .getResult()
                    .getOutput()
                    .getContent();

            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
