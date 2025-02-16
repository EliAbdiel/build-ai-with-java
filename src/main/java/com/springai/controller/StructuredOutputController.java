package com.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class StructuredOutputController {

    private final ChatClient chatClient;

    public StructuredOutputController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/simple-output")
    public ResponseEntity<String> getResponse(@RequestParam String message) {
        try {
            var output = chatClient.prompt()
                    .user(message)
                    .call()
                    .chatResponse().getResult().getOutput().getContent();

            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }

    @GetMapping("/response-as-list")
    public ResponseEntity<List<String>> getResponseAsList(@RequestParam String message) {
        try {
            var output = chatClient.prompt()
                    .user(message)
                    .call()
                    .entity(new ListOutputConverter(new DefaultConversionService()));

            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonList("error: " + e.getMessage()));
        }
    }

    @GetMapping("/response-as-map")
    public ResponseEntity<?> getResponseAsMap(@RequestParam String message) {
        try {
            var output = chatClient.prompt()
                                .user(message)
                                .call()
                            .entity(new ParameterizedTypeReference<Map<String, Object>>() {});
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
