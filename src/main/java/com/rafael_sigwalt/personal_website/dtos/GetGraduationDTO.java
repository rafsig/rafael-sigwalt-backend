package com.rafael_sigwalt.personal_website.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael_sigwalt.personal_website.models.Graduation;

import java.time.LocalDate;

public class GetGraduationDTO {
    private int id;
    private String degree;
    private String programName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinished;
    private String institution;

    public GetGraduationDTO(Graduation graduation) {
        this.id = graduation.getId();
        this.degree = graduation.getDegree();
        this.programName = graduation.getProgramName();
        this.dateFinished = graduation.getDateFinished();
        this.institution = graduation.getInstitution();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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
