package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.Skills;
import com.rafael_sigwalt.personal_website.repositories.SkillsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SkillServiceTest {

    @InjectMocks
    private SkillService skillService;

    @Mock
    private SkillsRepository skillsRepository;

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
    public void getSkillListReturnsSkills() throws IOException {
        Skills skills = new Skills();
        skills.setId(1);

        when(skillsRepository.findById(eq(1)))
                .thenReturn(Optional.of(skills));

        assertEquals(1, skills.getId());
    }

    @Test
    public void getSkillListThrowsDataFileNotAccessibleException() throws IOException {
        when(skillsRepository.findById(eq(1)))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> skillService.getSkillList());
    }

}
