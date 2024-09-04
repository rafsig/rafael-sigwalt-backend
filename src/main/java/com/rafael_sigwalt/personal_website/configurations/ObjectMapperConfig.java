package com.rafael_sigwalt.personal_website.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper configObjectMapper() {

        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

}
