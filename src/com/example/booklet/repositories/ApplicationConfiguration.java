package com.example.booklet.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class ApplicationConfiguration {

    RedisConnectionFactory connectionFactory() {
	JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
	jedisConFactory.setHostName("localhost");
	jedisConFactory.setPort(6379);
	return jedisConFactory;
    }

    @Bean
    RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {

	RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
	template.setConnectionFactory(connectionFactory);

	return template;
    }
}
