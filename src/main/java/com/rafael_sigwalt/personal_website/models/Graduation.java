package com.rafael_sigwalt.personal_website.models;

import java.time.LocalDate;

public class Graduation {

    private int id;
    private String degree;
    private String programName;
    private LocalDate dateConcluded;
    private String institution;

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
