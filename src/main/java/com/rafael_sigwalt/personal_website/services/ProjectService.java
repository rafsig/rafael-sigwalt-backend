package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProjectService {

    private Resource fileResource = new ClassPathResource("data/projects.json");

    @Autowired
    private ObjectMapper mapper;

    private TypeReference<List<Project>> typeReference = new TypeReference<List<Project>>() {};

    public List<Project> getProjectList(){
        try {
            return mapper
                    .readValue(fileResource.getInputStream(),
                            typeReference);
        } catch (IOException ex) {
            throw new DataFileNotAccessibleException(ex);
        }
    }

    public Project getProjectById(int id) {
        try {
            List<Project> projectList = mapper
                    .readValue(fileResource.getInputStream(),
                            typeReference);

            return projectList
                    .stream()
                    .filter(item -> id == item.getId())
                    .findFirst()
                    .orElseThrow(() -> new IOException());

        } catch (IOException ex) {
            throw new DataFileNotAccessibleException(ex);
        }
    }

    public void setResourceFile(Resource resource) {
        this.fileResource = resource;
    }

    public TypeReference<List<Project>> getTypeReference() {
        return this.typeReference;
    }
}
