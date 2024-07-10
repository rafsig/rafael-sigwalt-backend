package com.rafael_sigwalt.personal_website.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.dtos.GetWorkExperienceDTO;
import com.rafael_sigwalt.personal_website.models.WorkExperience;
import com.rafael_sigwalt.personal_website.services.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workExperience")
public class WorkExperienceController{

    @Autowired
    WorkExperienceService workExperienceService;

    @GetMapping
    public ResponseEntity<Iterable<GetWorkExperienceDTO>> getWorkExperiences() {
        List<WorkExperience> workExperienceList = workExperienceService.getWorkExperienceList();

        return ResponseEntity
                .ok( workExperienceList
                        .stream()
                        .map(GetWorkExperienceDTO::new)
                        .collect(Collectors.toList()));
    }
}