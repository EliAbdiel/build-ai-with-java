package com.springai.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.redis.RedisVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPooled;

@Configuration
public class RedisConfig {

    @Bean
    RedisVectorStore redisVectorStore(EmbeddingModel embeddingModel,
                                      JedisConnectionFactory jedisConnectionFactory) {
        return null;
    }
}
