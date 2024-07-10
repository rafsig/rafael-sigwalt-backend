package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WorkExperienceService {

    private Resource fileResource = new ClassPathResource("data/workExperience.json");

    @Autowired
    private ObjectMapper mapper;

    private TypeReference<List<WorkExperience>> typeReference = new TypeReference<List<WorkExperience>>() {};

    public List<WorkExperience> getWorkExperienceList() {
        try {
            return mapper
                    .readValue(fileResource.getInputStream(),
                            typeReference);
        } catch (IOException ex) {
            throw new DataFileNotAccessibleException(ex);
        }
    }

    public void setFileResource(Resource resource) {
        fileResource = resource;
    }

    public TypeReference<List<WorkExperience>> getTypeReference() {
        return typeReference;
    }
}
