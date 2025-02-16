package com.springai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final ChatClient chatClient;

    @Value("classpath:prompts/movie-template.st")
    private Resource movieResource;

    public MovieService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ResponseEntity<String> movieInfo(String movieName) {
        try {
            var result = chatClient.prompt()
                    .user(userSpec -> userSpec.text(movieResource)
                            .param("moviename", movieName)
                    )
                    .call()
                    .chatResponse()
                    .getResult()
                    .getOutput()
                    .getContent();

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
