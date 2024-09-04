package com.rafael_sigwalt.personal_website.repositories;

import com.rafael_sigwalt.personal_website.models.WorkExperience;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkExperiencesRepository extends MongoRepository<WorkExperience, Integer> {
}
