package com.springai.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ai.document.Document;
//import org.springframework.ai.transformer.splitter.TextSplitter;
//import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.ai.vectorstore.SearchRequest;
//import org.springframework.ai.vectorstore.VectorStore;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.List;
//import java.util.stream.Collectors;

//@RestController
public class ChromaController {
//
//    Logger logger = LoggerFactory.getLogger(ChromaController.class);
//
//    @Value("classpath:store.txt")
//    private Resource resource;
//
//    private final VectorStore vectorStore;
//
//    public ChromaController(VectorStore vectorStore) {
//        this.vectorStore = vectorStore;
//    }
//
//    @GetMapping("/load-info")
//    public String load() throws IOException, InterruptedException {
//        List<Document> documents = Files.lines(resource.getFile().toPath())
//                .map(Document::new)
//                .collect(Collectors.toList());
//
//        TextSplitter textSplitter = new TokenTextSplitter();
//
//        for(Document document: documents) {
//            List<Document> splitteddocs = textSplitter.split(document);
//            logger.info("Before adding document: {}", document.getText());
//            vectorStore.add(splitteddocs);
//            Thread.sleep(61000);
//            logger.info("Added document: {}", document.getText());
//        }
//        return  "Loaded " + resource.getFilename();
//    }
//
//    @GetMapping("/search-info")
//    public String search() {
//        List<Document> results = vectorStore
//                .similaritySearch(
//                        SearchRequest
//                                .builder()
//                                .query("Give me information about LED TV, Gaming Laptop, Smartwatch, and Herbal Tea")
//                                .build()
//                );
//        return results.toString();
//    }
}
