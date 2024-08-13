package com.rafael_sigwalt.personal_website.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("graduations")
public class Graduation {

    @Id
    private int id;
    private String degree;
    private String programName;
    private LocalDate dateFinished;
    private String institution;

    public Graduation() {
    }

    public Graduation(int id, String degree, String programName, LocalDate dateFinished, String institution) {
        this.id = id;
        this.degree = degree;
        this.programName = programName;
        this.dateFinished = dateFinished;
        this.institution = institution;
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
