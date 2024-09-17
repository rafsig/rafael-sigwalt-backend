package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.models.Message;
import com.rafael_sigwalt.personal_website.repositories.MessageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private EncryptionService encryptionService;

    AutoCloseable autoCloseable;

    Message message;

    String fullName = "My Name";
    String email = "My email";


    @BeforeEach
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        message = new Message();
        message.setFullName("My Name");
        message.setEmail("My Email");
        message.setCompany("My Company");
        message.setMessage("My Message");

        Mockito.when(encryptionService.encryptData(message.getMessage())).thenReturn("my encrypted message");
        Mockito.when(encryptionService.encryptData(message.getCompany())).thenReturn("my encrypted company");
        Mockito.when(encryptionService.encryptData(message.getFullName())).thenReturn("my encrypted full name");
        Mockito.when(encryptionService.encryptData(message.getEmail())).thenReturn("my encrypted email");

        Mockito.when(messageRepository.save(message)).thenReturn(message);
    }

    @AfterEach
    public void teardown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void messageGetsSavedWithDate() {
        messageService.createMessage(message);

        Mockito.verify(messageRepository).save(message);
        Assertions.assertTrue(message.getDate() != null);
    }

    @Test void messageGetsEncrypted(){
        messageService.createMessage(message);

        Assertions.assertEquals("my encrypted message", message.getMessage());
        Assertions.assertEquals("my encrypted company", message.getCompany());
        Assertions.assertEquals("my encrypted email", message.getEmail());
        Assertions.assertEquals("my encrypted full name", message.getFullName());
    }
}
