package com.springai.service.impl;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ai.document.Document;
//import org.springframework.ai.transformer.splitter.TextSplitter;
//import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.ai.vectorstore.SearchRequest;
//import org.springframework.ai.vectorstore.VectorStore;
//import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;

//@Service
public class CassandraVectorStoreServiceImpl {

    //Logger logger = LoggerFactory.getLogger(CassandraVectorStoreServiceImpl.class);

    //private final VectorStore vectorStore;

//    public CassandraVectorStoreServiceImpl(VectorStore vectorStore) {
//        this.vectorStore = vectorStore;
//    }

//    public void getDocuments() {
//        List<Document> documents = List.of(
//                new Document("Spring AI rocks!!", Map.of("country", "UK", "year", 2020)),
//                new Document("The World is Big and Salvation Lurks Around the Corner", Map.of()),
//                new Document("You walk forward facing the past and you turn back toward the future.", Map.of("country", "NL", "year", 2023)));
//
//        TextSplitter splitter = new TokenTextSplitter();
//        documents.forEach(doc -> {
//            List<Document> splittedDocs = splitter.split(doc);
//            try {
//                TimeUnit.SECONDS.sleep(20);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            vectorStore.add(splittedDocs);
//            logger.info("Added document: {}", doc);
//        });
//    }

//    public List<Document> searchDocuments(String query) {
//        return vectorStore.similaritySearch(
//                SearchRequest.builder()
//                        .query(query)
//                        .topK(2)
//                        .build()
//        );
//    }
}
