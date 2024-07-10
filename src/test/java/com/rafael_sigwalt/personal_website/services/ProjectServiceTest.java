package com.rafael_sigwalt.personal_website.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael_sigwalt.personal_website.exceptions.DataFileNotAccessibleException;
import com.rafael_sigwalt.personal_website.models.Project;
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

public class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    Resource resource;

    AutoCloseable autoCloseable;

    InputStream inputStream;

    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        projectService.setResourceFile(resource);
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
    public void getProjectListReturnsProjectListInformation() throws IOException {
        List<Project> projectList = Arrays.asList(new Project(), new Project());

        when(resource.getInputStream()).thenReturn(inputStream);
        when(objectMapper.readValue(any(InputStream.class),
                eq(projectService.getTypeReference())))
                .thenReturn(projectList);

        List<Project> result = projectService.getProjectList();

        assertEquals(2, result.size());
    }

    @Test
    public void getProjectListThrowsDataFileNotAccessibleException() throws IOException {
        when(resource.getInputStream()).thenThrow(new IOException());

        assertThrows(DataFileNotAccessibleException.class,
                () -> projectService.getProjectList());
    }

    @Test
    public void getProjectByIdReturnsProjectFilteredById() throws IOException{
        Project project1 = new Project();
        project1.setId(1);
        Project project2 = new Project();
        project2.setId(2);

        List<Project> projectList = Arrays.asList(project1, project2);

        when(resource.getInputStream()).thenReturn(inputStream);
        when(objectMapper.readValue(any(InputStream.class),
                eq(projectService.getTypeReference())))
                .thenReturn(projectList);

        Project result = projectService.getProjectById(2);

        assertEquals(2, result.getId());
    }

    @Test
    public void getProjectByIdThrowsDataFileNotAccessibleException() throws IOException {
        when(resource.getInputStream()).thenThrow(new IOException());

        assertThrows(DataFileNotAccessibleException.class,
                () -> projectService.getProjectById(2));
    }

}
