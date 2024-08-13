package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.About;
import com.rafael_sigwalt.personal_website.repositories.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AboutService {

    @Autowired
    AboutRepository aboutRepository;

    public AboutService(){}

    public About getAbout() {
        try {

            return aboutRepository.findById(1).orElseThrow();
        } catch(NoSuchElementException ex) {
            throw new ResourceNotFoundException(ex);
        }
    }

}
