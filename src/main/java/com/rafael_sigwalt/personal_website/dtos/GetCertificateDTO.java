package com.rafael_sigwalt.personal_website.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael_sigwalt.personal_website.models.Certificate;

import java.time.LocalDate;
import java.util.List;

public class GetCertificateDTO {

    private int id;
    private String imageUrl;
    private String title;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateFinished ;
    private String institution;
    private String url;
    private List<String> outcomes;
    private List<Integer> children;

    public GetCertificateDTO(Certificate certificate) {
        this.id = certificate.getId();
        this.imageUrl = certificate.getImageUrl();
        this.title = certificate.getTitle();
        dateFinished = certificate.getDateFinished();
        this.institution = certificate.getInstitution();
        this.url = certificate.getUrl();
        this.outcomes = certificate.getOutcomes();
        this.children = certificate.getChildren();
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

    public LocalDate getConcluded() {
        return dateFinished;
    }

    public void setConcluded(LocalDate dateFinished) {
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

    public List<String> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<String> outcomes) {
        this.outcomes = outcomes;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }
}
