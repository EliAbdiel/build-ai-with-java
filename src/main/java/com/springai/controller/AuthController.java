package com.springai.controller;

import com.springai.entity.UserEntity;
import com.springai.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserEntity user, BindingResult result) {
        user.setAdmin(false);
        return create(user, result);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserEntity user, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationField(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    private ResponseEntity<?> validationField(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "Field error " + error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
