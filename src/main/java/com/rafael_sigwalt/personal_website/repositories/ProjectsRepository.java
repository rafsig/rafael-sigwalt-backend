package com.rafael_sigwalt.personal_website.repositories;

import com.rafael_sigwalt.personal_website.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectsRepository extends MongoRepository<Project, Integer> {
}
