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

    private String recipeTemplate = """
            Answer for {foodName} for {question}?
            """;

    public RecipeGeneratorImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public ResponseEntity<Answer> generateRecipe(Question question) {
        Answer answer = new Answer(getMessage(question).getResult().getOutput().getContent());
        return ResponseEntity.ok(answer);
    }

    private ChatResponse getMessage(Question question) {
        try {
            return this.chatClient.prompt()
                    .user(userSpec -> userSpec.text(recipeTemplate)
                            .param("foodName", question.getFoodName())
                            .param("question", question.getQuestion())
                    )
                    .call()
                    .chatResponse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
