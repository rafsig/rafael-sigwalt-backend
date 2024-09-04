package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.Project;
import com.rafael_sigwalt.personal_website.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {

   @Autowired
   private ProjectsRepository projectsRepository;

    public List<Project> getProjectList(){
            return projectsRepository.findAll();
    }

    public Project getProjectById(int id) {
        try {
           return projectsRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new ResourceNotFoundException(ex);
        }
    }
}
