package com.rafael_sigwalt.personal_website.configurations;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.rafael_sigwalt.personal_website.utils.Base64Utils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@Configuration
public class MongoDBConfig {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${host}")
    private String host;

    @Value("${port}")
    private String port;

    @Value("${database}")
    private String database;

    @Value("${truststore}")
    private String b64Truststore;

    @Value("${truststorePassword}")
    private String trustStorePassword;

    public static final String TRUST_STORE = "truststore.jks";

    public static final String TRUST_STORE_TYPE = "JKS";

    @PostConstruct
    private void createTrustStoreFile(){
        try {
            Files.write(Paths.get(TRUST_STORE), new Base64Utils().decodeBase64(b64Truststore));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public MongoClientSettings mongoClientSettings() {
        setSslProperties();
        String connectionString =
                String.format(
                    "mongodb://%s:%s@%s:%s/%s?ssl=true&replicaSet=rs0&readPreference=primary&retryWrites=false",
                    username,
                    password,
                    host,
                    port,
                    database);
        System.out.println("\nMongo connection:" + connectionString + "/n");
        ConnectionString connString = new ConnectionString(connectionString);
        return MongoClientSettings
                .builder()
                .applyConnectionString(connString)
                .applyToSslSettings(builder -> builder.enabled(true))
                .build();
    }

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(mongoClientSettings());
    }

    private void setSslProperties() {
        System.setProperty("javax.net.ssl.trustStore", TRUST_STORE);
        System.setProperty("javax.net.ssl.trustStoreType", TRUST_STORE_TYPE);
        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "personalWebsite");
    }
}
