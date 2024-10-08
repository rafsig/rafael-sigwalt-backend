package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.Skills;

import java.util.List;

public class GetSkillListDTO {

    private int id;

    private List<String> skills;

    public GetSkillListDTO(Skills skills) {
        this.id = skills.getId();
        this.skills = skills.getSkills();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
