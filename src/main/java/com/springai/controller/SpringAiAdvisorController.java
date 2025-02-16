package com.springai.controller;

import com.springai.service.SpringAiAdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAiAdvisorController {

    private final SpringAiAdvisorService advisorService;

    public SpringAiAdvisorController(SpringAiAdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @GetMapping("/start-chat")
    public ResponseEntity<String> startChat(@RequestParam String message) {
        return advisorService.getResponse(message);
    }
}
