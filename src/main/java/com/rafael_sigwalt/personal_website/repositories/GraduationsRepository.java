package com.rafael_sigwalt.personal_website.repositories;

import com.rafael_sigwalt.personal_website.models.Graduation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GraduationsRepository extends MongoRepository<Graduation, Integer> {
}
