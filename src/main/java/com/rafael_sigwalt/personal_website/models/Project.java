package com.rafael_sigwalt.personal_website.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("projects")
public class Project {
    private int id;
    private String title;
    private String description;
    private String shortDescription;
    private String imageUrl;
    private String git;
    private List<String> skills;
    private List<String> nextSteps;
    private List<Integer> children;
    public Project() {
    }

    public Project(int id, String title, String description, String shortDescription, String imageUrl, String git, List<String> skills, List<String> nextSteps, List<Integer> children) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.shortDescription = shortDescription;
        this.imageUrl = imageUrl;
        this.git = git;
        this.skills = skills;
        this.nextSteps = nextSteps;
        this.children = children;
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

    public List<String> getNextSteps() {
        return nextSteps;
    }

    public void setNextSteps(List<String> nextSteps) {
        this.nextSteps = nextSteps;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }
}
