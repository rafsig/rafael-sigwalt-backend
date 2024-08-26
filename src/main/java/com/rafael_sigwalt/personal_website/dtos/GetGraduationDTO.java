package com.rafael_sigwalt.personal_website.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael_sigwalt.personal_website.models.Graduation;

import java.time.LocalDate;

public class GetGraduationDTO {
    private int id;
    private String degree;
    private String programName;
    @JsonFormat(pattern = "MMM yyyy")
    private LocalDate dateConcluded;
    private String institution;


    public GetGraduationDTO(Graduation graduation) {
        id = graduation.getId();
        degree = graduation.getDegree();
        programName = graduation.getProgramName();
        dateConcluded = graduation.getDateConcluded();
        institution = graduation.getInstitution();
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

    public LocalDate getDateConcluded() {
        return dateConcluded;
    }

    public void setDateConcluded(LocalDate dateConcluded) {
        this.dateConcluded = dateConcluded;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
