package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.Project;
import com.rafael_sigwalt.personal_website.repositories.ProjectsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ProjectsRepository projectsRepository;

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
    public void getProjectListReturnsProjectListInformation() throws IOException {
        List<Project> projectList = Arrays.asList(new Project(), new Project());

        when(projectsRepository.findAll())
                .thenReturn(projectList);

        List<Project> result = projectService.getProjectList();

        assertEquals(2, result.size());
    }

    @Test
    public void getProjectByIdReturnsProjectFilteredById() throws IOException{
        Project project = new Project();
        project.setId(1);

        when(projectsRepository.findById(eq(1)))
                .thenReturn(Optional.of(project));

        Project result = projectService.getProjectById(2);

        assertEquals(2, result.getId());
    }

    @Test
    public void getProjectByIdThrowsDataFileNotAccessibleException() throws IOException {
        when(projectsRepository.findById(eq(1)))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> projectService.getProjectById(2));
    }

}
