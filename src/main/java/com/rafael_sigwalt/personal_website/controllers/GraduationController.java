package com.rafael_sigwalt.personal_website.controllers;

import com.rafael_sigwalt.personal_website.dtos.GetGraduationDTO;
import com.rafael_sigwalt.personal_website.models.Graduation;
import com.rafael_sigwalt.personal_website.services.GraduationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/graduation")
public class GraduationController {

    @Autowired
    private GraduationService graduationService;

    @GetMapping
    public ResponseEntity<Iterable<GetGraduationDTO>> getProjectList() {
        List<Graduation> projectList = graduationService.getGraduationList();

        return ResponseEntity
                .ok(projectList
                        .stream()
                        .map(GetGraduationDTO::new)
                        .collect(Collectors.toList()));
    }
}
