package com.rafael_sigwalt.personal_website.repositories;

import com.rafael_sigwalt.personal_website.models.Skills;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillsRepository extends MongoRepository<Skills, Integer> {
}
