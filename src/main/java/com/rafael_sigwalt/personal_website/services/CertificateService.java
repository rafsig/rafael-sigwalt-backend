package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.Certificate;
import com.rafael_sigwalt.personal_website.repositories.CertificatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CertificateService {

    @Autowired
    private CertificatesRepository certificatesRepository;


    public Page<Certificate> getCertificateList(int numPerPage, int page) {
        Pageable pageable = PageRequest.of(page, numPerPage, Sort.by(Sort.Direction.DESC, "dateFinished" ));
        return certificatesRepository.findAll(pageable);
    }

    public Certificate getCertificateById(int id) {
        try {
           return certificatesRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new ResourceNotFoundException(ex);
        }
    }
}
