package com.rafael_sigwalt.personal_website.controllers;

import com.rafael_sigwalt.personal_website.dtos.GetProjectDTO;
import com.rafael_sigwalt.personal_website.dtos.GetProjectListDTO;
import com.rafael_sigwalt.personal_website.models.Project;
import com.rafael_sigwalt.personal_website.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/project")
public class ProjectsController{

    @Autowired
    private ProjectService projectService;


    @GetMapping
    public ResponseEntity<Iterable<GetProjectListDTO>> getProjectList() {
        List<Project> projectList = projectService.getProjectList();

        return ResponseEntity
                .ok(projectList
                        .stream()
                        .map(GetProjectListDTO::new)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProjectDTO> getProject(@PathVariable  int id) {
        return ResponseEntity
                .ok(new GetProjectDTO(projectService.getProjectById(id)));
    }


}