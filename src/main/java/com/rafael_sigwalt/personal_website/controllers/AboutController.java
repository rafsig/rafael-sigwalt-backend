package com.rafael_sigwalt.personal_website.controllers;

import com.rafael_sigwalt.personal_website.dtos.GetAboutDTO;
import com.rafael_sigwalt.personal_website.models.About;
import com.rafael_sigwalt.personal_website.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @GetMapping
    public ResponseEntity<GetAboutDTO> getAbout() {
        About about = aboutService.getAbout();

        return ResponseEntity.ok(new GetAboutDTO(about));
    }

}