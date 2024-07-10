package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.Project;

import java.util.List;

public class GetProjectListDTO {

    private int id;
    private String title;
    private String shortDescription;
    private String imageUrl;
    private String git;
    private List<String> skills;

    public GetProjectListDTO(Project project) {
        id =project.getId();
        title = project.getTitle();
        shortDescription = project.getShortDescription();
        imageUrl = project.getImageUrl();
        git = project.getGit();
        skills = project.getSkills();
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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
}
