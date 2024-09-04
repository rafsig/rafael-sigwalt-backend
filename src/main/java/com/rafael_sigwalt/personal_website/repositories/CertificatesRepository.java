package com.rafael_sigwalt.personal_website.repositories;

import com.rafael_sigwalt.personal_website.models.Certificate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CertificatesRepository extends MongoRepository<Certificate, Integer> {
}
