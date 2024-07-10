package com.rafael_sigwalt.personal_website.controllers;

import com.rafael_sigwalt.personal_website.dtos.GetSkillListDTO;
import com.rafael_sigwalt.personal_website.models.Skill;
import com.rafael_sigwalt.personal_website.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("skill")
public class SkillsController{

    @Autowired
    private SkillService skillService;


    @GetMapping
    public ResponseEntity<Iterable<GetSkillListDTO>> getSkills() {
        List<Skill> skillList =  skillService.getSkillList();
        return ResponseEntity
                .ok( skillList
                        .stream()
                        .map(GetSkillListDTO::new)
                        .collect(Collectors.toList()));
    }

}