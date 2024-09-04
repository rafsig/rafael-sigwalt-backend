package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.models.WorkExperience;
import com.rafael_sigwalt.personal_website.repositories.WorkExperiencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceService {

    @Autowired
    private WorkExperiencesRepository workExperiencesRepository;

    public List<WorkExperience> getWorkExperienceList() {
        return workExperiencesRepository.findAll();
    }

}
