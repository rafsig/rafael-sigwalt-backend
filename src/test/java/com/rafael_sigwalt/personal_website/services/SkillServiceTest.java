package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.Skill;
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

public class SkillServiceTest {

    @InjectMocks
    private SkillService skillService;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    Resource resource;

    AutoCloseable autoCloseable;

    InputStream inputStream;

    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        skillService.setResourceFile(resource);
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
    public void getSkillListReturnsSkills() throws IOException {
        List<Skill> skillList = Arrays.asList(new Skill(), new Skill());

        when(resource.getInputStream()).thenReturn(inputStream);
        when(objectMapper.readValue(any(InputStream.class),
                eq(skillService.getTypeReference())))
                .thenReturn(skillList);

        assertEquals(2, skillList.size());
    }

    @Test
    public void getSkillListThrowsDataFileNotAccessibleException() throws IOException {
        when(resource.getInputStream()).thenThrow(new IOException());

        assertThrows(DataFileNotAccessibleException.class,
                () -> skillService.getSkillList());
    }

}
