package com.rafael_sigwalt.personal_website.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael_sigwalt.personal_website.models.Certificate;

import java.time.LocalDate;

public class GetCertificateListDTO {

    private Integer id;
    private String imagePath;
    private String title;
    @JsonFormat(pattern="MMM yyyy")
    private LocalDate concluded;
    private String institution;

    public GetCertificateListDTO(Certificate certificate) {
        id = certificate.getId();
        imagePath = certificate.getImagePath();
        title = certificate.getTitle();
        concluded = certificate.getConcluded();
        institution = certificate.getInstitution();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
