package com.springai.controller;

import com.springai.service.impl.CassandraVectorStoreServiceImpl;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cassandra")
public class CassandraVectorStoreController {

    private final CassandraVectorStoreServiceImpl cassandraVectorStoreService;

    public CassandraVectorStoreController(CassandraVectorStoreServiceImpl cassandraVectorStoreService) {
        this.cassandraVectorStoreService = cassandraVectorStoreService;
    }

    @GetMapping("/load")
    public void loadDocuments() {
        cassandraVectorStoreService.getDocuments();
    }

    @GetMapping("/search")
    public List<Document> search() {
        return cassandraVectorStoreService.searchDocuments("Technology");
    }
}
