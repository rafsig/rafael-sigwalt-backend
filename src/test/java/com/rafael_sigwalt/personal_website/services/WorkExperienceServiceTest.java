package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.models.WorkExperience;
import com.rafael_sigwalt.personal_website.repositories.WorkExperiencesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkExperienceServiceTest {

    @InjectMocks
    private WorkExperienceService workExperienceService;

    @Mock private WorkExperiencesRepository workExperiencesRepository;

    AutoCloseable autoCloseable;


    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void getWorkExperienceListReturnsWorkExperiences() throws IOException {
        List<WorkExperience> workExperienceList = Arrays.asList(new WorkExperience(), new WorkExperience());

        when(workExperiencesRepository.findAll())
                .thenReturn(workExperienceList);

        assertEquals(2, workExperienceList.size());
    }
}
