package com.synerzip.springwithmongo.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {

	@Bean
	public Mongo mongo() throws UnknownHostException {
		return new MongoClient("localhost");
	}

	public @Bean
	MongoTemplate mongoTemplate() throws UnknownHostException {
		return new MongoTemplate(mongo(), "users");
	}
}