package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.About;
import com.rafael_sigwalt.personal_website.models.Links;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutServiceTest {

    @InjectMocks
    private AboutService aboutService;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    Resource resource;

    AutoCloseable autoCloseable;

    InputStream inputStream;

    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        aboutService.setResourceFile(resource);
        inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }

    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void getAboutReturnsAboutInformation() throws IOException {
        String expectedName = "John";
        String expectedLastName = "Doe";
        String expectedPersonalDescription = "personal";
        String expectedProfessionalDescription = "professional";
        String expectedGit = "git";
        String expectedLinkedIn = "linkedIn";

        About about = new About();
        about.setFirstName(expectedName);
        about.setLastName(expectedLastName);
        about.setPersonalDescription(expectedPersonalDescription);
        about.setProfessionalDescription(expectedProfessionalDescription);
        Links links = new Links();
        links.setGithub(expectedGit);
        links.setLinkedIn(expectedLinkedIn);
        about.setLinks(links);

        when(resource.getInputStream()).thenReturn(inputStream);
        when(objectMapper.readValue(any(InputStream.class),
                eq(About.class)))
                .thenReturn(about);

        About result = aboutService.getAbout();

        assertEquals(expectedName, result.getFirstName());
        assertEquals(expectedLastName, result.getLastName());
        assertEquals(expectedProfessionalDescription, result.getProfessionalDescription());
        assertEquals(expectedPersonalDescription, result.getPersonalDescription());
        assertEquals(expectedLinkedIn, result.getLinks().getLinkedIn());
        assertEquals(expectedGit, result.getLinks().getGithub());
    }

    @Test
    public void getAboutThrowsDataFileNotAccessibleException() throws IOException {
        when(resource.getInputStream()).thenThrow(new IOException());

       assertThrows(DataFileNotAccessibleException.class,
               () -> aboutService.getAbout());
    }


}
