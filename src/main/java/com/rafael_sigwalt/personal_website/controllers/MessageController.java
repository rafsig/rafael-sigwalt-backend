package com.rafael_sigwalt.personal_website.controllers;

import com.rafael_sigwalt.personal_website.dtos.PostMessageDTO;
import com.rafael_sigwalt.personal_website.models.Message;
import com.rafael_sigwalt.personal_website.services.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Void> addMessage(@RequestBody @Valid PostMessageDTO messageDTO) {

        messageService.createMessage(messageDTO.getMessage());

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
