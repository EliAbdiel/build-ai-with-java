package com.springai.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.mongodb.atlas.MongoDBAtlasVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfig {

    @Bean
    public VectorStore mongodbVectorStore(MongoTemplate mongoTemplate, EmbeddingModel embeddingModel) {
        return MongoDBAtlasVectorStore.builder(mongoTemplate, embeddingModel)
                //.collectionName("custom_vector_store")           // Optional: defaults to "vector_store"
                //.vectorIndexName("custom_vector_index")          // Optional: defaults to "vector_index"
                //.pathName("custom_embedding")                    // Optional: defaults to "embedding"
                //.numCandidates(500)                             // Optional: defaults to 200
                //.metadataFieldsToFilter(List.of("author", "year")) // Optional: defaults to empty list
                //.initializeSchema(true)                         // Optional: defaults to false
                //.batchingStrategy(new TokenCountBatchingStrategy()) // Optional: defaults to TokenCountBatchingStrategy
                .build();
    }
}
