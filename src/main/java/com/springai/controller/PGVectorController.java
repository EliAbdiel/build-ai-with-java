package com.springai.controller;

import com.springai.service.impl.PGVectorServiceImpl;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pgvector")
public class PGVectorController {

    private final PGVectorServiceImpl pgVectorService;

    public PGVectorController(PGVectorServiceImpl pgVectorService) {
        this.pgVectorService = pgVectorService;
    }

    @GetMapping("/load")
    public void load() throws IOException {
        pgVectorService.loadDocuments();
    }

    @GetMapping("/search")
    public List<Document> search(){
        return pgVectorService.search("laptop");
    }

    @GetMapping("/content")
    public String content() {
        return pgVectorService.getContent("smartwatch");
    }
}
