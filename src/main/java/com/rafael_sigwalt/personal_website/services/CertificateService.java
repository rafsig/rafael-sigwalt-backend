package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CertificateService {

    private Resource fileResource = new ClassPathResource("data/certificates.json");

    @Autowired
    private ObjectMapper mapper;

    private TypeReference<List<Certificate>> typeReference = new TypeReference<List<Certificate>>() {};

    public List<Certificate> getCertificateList(){
        try {
            mapper.registerModule(new JavaTimeModule());
            return mapper
                    .readValue(fileResource.getInputStream(),
                            typeReference);
        } catch (IOException ex) {
            throw new DataFileNotAccessibleException(ex);
        }
    }

    public Certificate getCertificateById(int id) {
        try {
            mapper.registerModule(new JavaTimeModule());
            List<Certificate> certificateList = mapper
                    .readValue(fileResource.getInputStream(),
                            typeReference);

            return certificateList
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

    public TypeReference<List<Certificate>> getTypeReference() {
        return this.typeReference;
    }
}
