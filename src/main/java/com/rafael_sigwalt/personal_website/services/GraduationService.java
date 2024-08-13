package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.models.Graduation;
import com.rafael_sigwalt.personal_website.repositories.GraduationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GraduationService {

    @Autowired
    private GraduationsRepository graduationsRepository;

    public List<Graduation> getGraduationList() {
        return graduationsRepository.findAll();
    }
}
