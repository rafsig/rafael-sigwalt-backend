package com.rafael_sigwalt.personal_website.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael_sigwalt.personal_website.models.Certificate;

import java.time.LocalDate;

public class GetCertificateListDTO {

    private int id;
    private String imageUrl;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinished;
    private String institution;

    public GetCertificateListDTO(Certificate certificate) {
        id= certificate.getId();
        imageUrl = certificate.getImageUrl();
        title = certificate.getTitle();
        dateFinished = certificate.getDateFinished();
        institution = certificate.getInstitution();
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
}
