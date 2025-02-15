package com.springai.controller;

import com.springai.model.Answer;
import com.springai.model.Question;
import com.springai.service.RecipeGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    private final RecipeGenerator recipeGenerator;

    public RecipeController(RecipeGenerator recipeGenerator) {
        this.recipeGenerator = recipeGenerator;
    }

    @GetMapping("/generate-recipe")
    public ResponseEntity<Answer> generateRecipe(@RequestParam String question) {
        return recipeGenerator.generateRecipe(new Question(question));
    }
}
