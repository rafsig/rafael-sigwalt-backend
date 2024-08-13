package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.models.Graduation;
import com.rafael_sigwalt.personal_website.repositories.GraduationsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GraduationServiceTest {

    @InjectMocks
    private GraduationService graduationService;

    @Mock
    private GraduationsRepository graduationsRepository;

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
    public void getGraduationListReturnsGraduationListInformation() throws IOException {
        List<Graduation> graduationList = Arrays.asList(new Graduation(), new Graduation());

        when(graduationsRepository.findAll())
                .thenReturn(graduationList);

        List<Graduation> result = graduationService.getGraduationList();

        assertEquals(2, result.size());
    }
}
