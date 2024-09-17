package com.rafael_sigwalt.personal_website.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import java.security.NoSuchAlgorithmException;

public class EncryptionServiceTest {

    @InjectMocks
    private EncryptionService encryptionService;



    @BeforeEach
    public void setup() throws NoSuchAlgorithmException {
        MockitoAnnotations.openMocks(this);

        ReflectionTestUtils.setField(encryptionService, "key", "1234567890abcdef1234567890abcdef");
    }

    @Test
    public void testEncryption() {
        String encryptedText = encryptionService.encryptData("Hello World");

        Assertions.assertNotNull(encryptedText);
        Assertions.assertNotEquals("Hello World", encryptedText);
    }

    @Test
    public void testEncryptionAndDecryption() {
        String encryptedText = encryptionService.encryptData("Hello World");
        String decryptedText = encryptionService.decryptData(encryptedText);

        Assertions.assertEquals("Hello World", decryptedText);
    }
}
