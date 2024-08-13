package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.ResourceNotFoundException;
import com.rafael_sigwalt.personal_website.models.Certificate;
import com.rafael_sigwalt.personal_website.repositories.CertificatesRepository;
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

public class CertificateServiceTest {

    @InjectMocks
    private CertificateService certificateService;

    @Mock
    private CertificatesRepository certificatesRepository;

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
    public void getCertificateListReturnsCertificateListInformation() throws IOException {
        List<Certificate> certificateList = Arrays.asList(new Certificate(), new Certificate());

        when(certificatesRepository.findAll())
                .thenReturn(certificateList);

        List<Certificate> result = certificateService.getCertificateList();

        assertEquals(2, result.size());
    }

    @Test
    public void getCertificateByIdReturnsCertificateFilteredById() throws IOException{
        Certificate certificate = new Certificate();
        certificate.setId(1);

        when(certificatesRepository.findById(eq(1)))
                .thenReturn(Optional.of(certificate));

        Certificate result = certificateService.getCertificateById(1);

        assertEquals(1, result.getId());
    }

    @Test
    public void getCertificateByIdThrowsDataFileNotAccessibleException() throws IOException{
        when(certificatesRepository.findById(eq(1)))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> certificateService.getCertificateById(1));
    }

}
