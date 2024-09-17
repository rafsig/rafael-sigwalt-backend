package com.rafael_sigwalt.personal_website.services;

import ch.qos.logback.core.util.StringUtil;
import com.rafael_sigwalt.personal_website.models.Message;
import com.rafael_sigwalt.personal_website.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EncryptionService encryptionService;

    public void createMessage(Message message){
        message.setDate(LocalDate.now());

        if(!StringUtil.isNullOrEmpty(message.getCompany())){
            message.setCompany(encryptionService.encryptData(message.getCompany()));
        }
        if(!StringUtil.isNullOrEmpty(message.getEmail())){
            message.setEmail(encryptionService.encryptData(message.getEmail()));
        }
        if(!StringUtil.isNullOrEmpty(message.getFullName())) {
            message.setFullName(encryptionService.encryptData(message.getFullName()));
        }
        if(!StringUtil.isNullOrEmpty(message.getMessage())) {
            message.setMessage(encryptionService.encryptData(message.getMessage()));
        }
        messageRepository.save(message);
    }
}
