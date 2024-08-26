package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.Graduation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GraduationService {

    private Resource fileResource = new ClassPathResource("data/graduations.json");

    @Autowired
    private ObjectMapper mapper;

    private TypeReference<List<Graduation>> typeReference = new TypeReference<List<Graduation>>() {};

    public List<Graduation> getGraduationList(){
        try {
            mapper.registerModule(new JavaTimeModule());
            return mapper
                    .readValue(fileResource.getInputStream(),
                            typeReference);
        } catch (IOException ex) {
            throw new DataFileNotAccessibleException(ex);
        }
    }
}
