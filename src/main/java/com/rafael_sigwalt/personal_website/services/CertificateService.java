package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.Certificate;
import com.rafael_sigwalt.personal_website.repositories.CertificatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CertificateService {

    @Autowired
    private CertificatesRepository certificatesRepository;


    public List<Certificate> getCertificateList() {
        return certificatesRepository.findAll();
    }

    public Certificate getCertificateById(int id) {
        try {
           return certificatesRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new ResourceNotFoundException(ex);
        }
    }
}
