package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.Skill;

public class GetSkillListDTO {

    private int id;
    private String description;

    public GetSkillListDTO(Skill skill) {
        id = skill.getId();
        description = skill.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
