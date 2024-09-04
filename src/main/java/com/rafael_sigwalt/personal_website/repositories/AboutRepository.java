package com.rafael_sigwalt.personal_website.repositories;

import com.rafael_sigwalt.personal_website.models.About;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AboutRepository extends MongoRepository<About, Integer> {
}
