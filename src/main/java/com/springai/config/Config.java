package com.springai.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.List;

@Configuration
public class Config {

    Logger logger = LoggerFactory.getLogger(Config.class);

    //@Value("classpath:input.txt")
    //Resource resource;

     //@Value("classpath:newproducts.txt")
     //Resource newProductsResource;

    String input = """
            You are an AI assistant that specializes in {subject}.
            You respond in a {tone} voice with detailed explanations.
            """;

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        // return builder.defaultSystem(resource)
        //        .build();
        return builder.build();
    }

//    @Bean
//    SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel) {
//        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(embeddingModel).build();
//        File file = new File("C:\\Users\\NETCOM7\\Desktop\\code\\spring\\springai-quickstart\\src\\main\\resources\\newproducts.json");
//        if (file.exists()) {
//            logger.info("File exists");
//            simpleVectorStore.load(file);
//        } else {
//            TextReader textReader = new TextReader(newProductsResource);
//            textReader.getCustomMetadata().put("filename", "newproducts.txt");
//            List<Document> documents = textReader.get();
//            TextSplitter textSplitter = new TokenTextSplitter();
//            List<Document> splitterDocuments = textSplitter.apply(documents);
//            simpleVectorStore.add(splitterDocuments);
//            simpleVectorStore.save(file);
//        }
//        return simpleVectorStore;
//    }

}
