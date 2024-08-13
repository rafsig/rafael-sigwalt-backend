package com.rafael_sigwalt.personal_website.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.rafael_sigwalt.personal_website.repositories")
public class MongoDBConfig {
}
