package com.springai.controller;

import com.springai.service.impl.MongoVectorStoreServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongos")
public class MongoVectorStoreController {

    private final MongoVectorStoreServiceImpl mongoVectorStoreService;

    public MongoVectorStoreController(MongoVectorStoreServiceImpl mongoVectorStoreService) {
        this.mongoVectorStoreService = mongoVectorStoreService;
    }

    @GetMapping("/load")
    public ResponseEntity<?> load() {
        return mongoVectorStoreService.load();
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(value = "query", defaultValue = "learn how to grow things") String query) {
        return mongoVectorStoreService.search(query);
    }
}
