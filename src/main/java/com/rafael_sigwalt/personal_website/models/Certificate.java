package com.rafael_sigwalt.personal_website.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document("certificates")
public class Certificate {

    @Id
    private Integer id;
    private Type type;
    private String imageUrl;
    private String title;
    private LocalDate dateFinished;
    private String institution;
    private String url;
    private List<Integer> children;
    private List<String> outcomes;

    public Certificate() {
    }

    public Certificate(Integer id, Type type, String imageUrl, String title, LocalDate dateFinished, String institution, String url, List<Integer> children, List<String> outcomes) {
        this.id = id;
        this.type = type;
        this.imageUrl = imageUrl;
        this.title = title;
        this.dateFinished = dateFinished;
        this.institution = institution;
        this.url = url;
        this.children = children;
        this.outcomes = outcomes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDate dateFinished) {
        this.dateFinished = dateFinished;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }

    public List<String> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<String> outcomes) {
        this.outcomes = outcomes;
    }
}
