package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class AboutService {

    private Resource resourceFile = new ClassPathResource("data/about.json");

    @Autowired
    private ObjectMapper mapper;

    public AboutService(){}

    public void setResourceFile(Resource resource) {
        resourceFile = resource;
    }

    public About getAbout() {
        try {
            return mapper.readValue(resourceFile.getInputStream(), About.class);
        } catch(IOException ex) {
            throw new DataFileNotAccessibleException(ex);
        }
    }

}
