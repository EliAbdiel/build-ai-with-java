package com.springai.service;

import com.springai.model.Answer;
import com.springai.model.Question;
import org.springframework.http.ResponseEntity;

public interface RecipeGenerator {

    ResponseEntity<Answer> generateRecipe(Question question);
}
