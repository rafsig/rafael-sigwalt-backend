package com.rafael_sigwalt.personal_website.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper configObjectMapper() {
        return new ObjectMapper();
    }

}
