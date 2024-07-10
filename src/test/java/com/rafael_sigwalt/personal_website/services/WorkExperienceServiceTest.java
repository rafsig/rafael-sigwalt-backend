package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.WorkExperience;
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
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkExperienceServiceTest {

    @InjectMocks
    private WorkExperienceService workExperienceService;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    Resource resource;

    AutoCloseable autoCloseable;

    InputStream inputStream;

    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        workExperienceService.setFileResource(resource);
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
    public void getWorkExperienceListReturnsWorkExperiences() throws IOException {
        List<WorkExperience> workExperienceList = Arrays.asList(new WorkExperience(), new WorkExperience());

        when(resource.getInputStream()).thenReturn(inputStream);
        when(objectMapper.readValue(any(InputStream.class),
                eq(workExperienceService.getTypeReference())))
                .thenReturn(workExperienceList);

        assertEquals(2, workExperienceList.size());
    }

    @Test
    public void getWorkExperienceListThrowsDataFileNotAccessibleException() throws IOException {
        when(resource.getInputStream()).thenThrow(new IOException());

        assertThrows(DataFileNotAccessibleException.class,
                () -> workExperienceService.getWorkExperienceList());
    }
}
