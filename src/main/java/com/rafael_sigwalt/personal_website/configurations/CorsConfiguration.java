package com.rafael_sigwalt.personal_website.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Value("${security.allowed-origins:''}")
    String allowedOrigin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if(!allowedOrigin.isEmpty()) {
            registry
                    .addMapping("/**")
                    .allowedOrigins(allowedOrigin);
        }
    }
}
