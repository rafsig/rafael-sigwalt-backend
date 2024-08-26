package com.rafael_sigwalt.personal_website.models;


import java.time.LocalDate;
import java.util.List;

public class Certificate {

    private Integer id;
    private String imagePath;
    private String title;
    private LocalDate concluded;
    private String institution;
    private String url;
    private List<String> outcomes;

    public Certificate() {
    }

    public Certificate(Integer id, String imageUrl, String title, LocalDate dateFinished, String institution, String url, List<String> outcomes) {
        this.id = id;
        this.imagePath = imageUrl;
        this.title = title;
        this.concluded = dateFinished;
        this.institution = institution;
        this.url = url;
        this.outcomes = outcomes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getConcluded() {
        return concluded;
    }

    public void setConcluded(LocalDate concluded) {
        this.concluded = concluded;
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

    public List<String> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<String> outcomes) {
        this.outcomes = outcomes;
    }
}
