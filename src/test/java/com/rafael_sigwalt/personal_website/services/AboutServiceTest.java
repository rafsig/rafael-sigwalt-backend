package com.rafael_sigwalt.personal_website.services;


import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.About;
import com.rafael_sigwalt.personal_website.models.Links;
import com.rafael_sigwalt.personal_website.repositories.AboutRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutServiceTest {

    @InjectMocks
    private AboutService aboutService;

    @Mock
    private AboutRepository aboutRepository;

    private AutoCloseable autoCloseable;


    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
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
        about.setPersonalDescription(expectedPersonalDescription);
        about.setProfessionalDescription(expectedProfessionalDescription);
        Links links = new Links();
        links.setGithub(expectedGit);
        links.setLinkedIn(expectedLinkedIn);
        about.setLinks(links);

        when(aboutRepository.findById(eq(1))).thenReturn(Optional.of(about));

        About result = aboutService.getAbout();

        assertEquals(expectedProfessionalDescription, result.getProfessionalDescription());
        assertEquals(expectedPersonalDescription, result.getPersonalDescription());
        assertEquals(expectedLinkedIn, result.getLinks().getLinkedIn());
        assertEquals(expectedGit, result.getLinks().getGithub());
    }

    @Test
    public void getAboutThrowsDataFileNotAccessibleException() throws IOException {
        when(aboutRepository.findById(1)).thenReturn(Optional.empty());

       assertThrows(ResourceNotFoundException.class,
               () -> aboutService.getAbout());
    }


}
