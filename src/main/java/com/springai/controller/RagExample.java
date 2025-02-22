package com.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RagExample {

    private final ChatClient chatClient;

    public RagExample(ChatClient.Builder chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient
                .defaultAdvisors(
                        new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    @GetMapping("/newproducts")
    public ResponseEntity<String> getResponse() {
        try {
            var response = chatClient.prompt()
                    .user("Give me a information about YieldMax")
                    .call()
                    .chatResponse()
                    .getResult().getOutput().getContent();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
