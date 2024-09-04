package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.Skills;
import com.rafael_sigwalt.personal_website.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SkillService {

    @Autowired
    private SkillsRepository skillsRepository;

    public Skills getSkillList() {
        try {
          return skillsRepository.findById(1).orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new ResourceNotFoundException(ex);
        }
    }
}
