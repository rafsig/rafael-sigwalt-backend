package com.rafael_sigwalt.personal_website.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("skills")
public class Skills {
    @Id
    private int id;
    private List<String> skills;

    public Skills(int id, List<String> skills) {
        this.id = id;
        this.skills = skills;
    }

    public Skills() {
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
