package com.springai.service.impl;

import com.springai.model.Answer;
import com.springai.model.Question;
import com.springai.service.RecipeGenerator;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RecipeGeneratorImpl implements RecipeGenerator {

    private ChatClient chatClient;

    public RecipeGeneratorImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public ResponseEntity<Answer> generateRecipe(Question question) {
        Answer answer = new Answer(getMessage(question.getQuestion()).getResult().getOutput().getContent());
        return ResponseEntity.ok(answer);
    }

    private ChatResponse getMessage(String message) {
        try {
            return this.chatClient.prompt()
                    .user(message)
                    .call()
                    .chatResponse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
