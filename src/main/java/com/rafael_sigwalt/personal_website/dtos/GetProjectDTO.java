package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.Project;

import java.util.List;

public class GetProjectDTO {

    private int id;
    private String title;
    private String description;
    private String imageUrl;
    private String git;
    private List<String> skills;
    private List<String> nextSteps;

    public GetProjectDTO(Project project) {
        id = project.getId();
        title = project.getTitle();
        description = project.getDescription();
        imageUrl = project.getImageUrl();
        git = project.getGit();
        skills = project.getSkills();
        nextSteps = project.getNextSteps();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getNextSteps() {
        return nextSteps;
    }

    public void setNextSteps(List<String> nextSteps) {
        this.nextSteps = nextSteps;
    }
}
