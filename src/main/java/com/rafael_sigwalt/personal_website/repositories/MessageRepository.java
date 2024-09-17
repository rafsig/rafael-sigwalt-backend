package com.rafael_sigwalt.personal_website.repositories;

import com.rafael_sigwalt.personal_website.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
