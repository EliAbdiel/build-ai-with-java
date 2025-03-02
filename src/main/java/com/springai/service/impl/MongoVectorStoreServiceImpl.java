package com.springai.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class MongoVectorStoreServiceImpl {

    Logger logger = LoggerFactory.getLogger(MongoVectorStoreServiceImpl.class);

    private final VectorStore vectorStore;

    @Value("classpath:data.txt")
    private Resource resource;

    public MongoVectorStoreServiceImpl(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public ResponseEntity<?> load() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.resource.getInputStream()))) {
            List<Document> docs = reader.lines()
                    .map(Document::new)
                    .toList();

            TokenTextSplitter tokenTextSplitter = new TokenTextSplitter();
            docs.forEach(doc -> {
                List<Document> splittedDocs = tokenTextSplitter.split(doc);
                vectorStore.add(splittedDocs);
                try {
                    TimeUnit.MILLISECONDS.sleep(20000);
                    logger.info("Added document: {}", doc);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            return ResponseEntity.ok("LOAD");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }

    public ResponseEntity<?> search (String query) {
        try {
            List<Document> results = vectorStore.similaritySearch(
                    SearchRequest
                            .builder()
                            .query(query)
                            .topK(2)
                            .build()
            );
            return ResponseEntity.ok(
                    results.stream()
                            .map(Document::getText)
                            .collect(Collectors.toList())
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
