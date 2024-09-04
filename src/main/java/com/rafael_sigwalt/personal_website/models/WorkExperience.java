package com.rafael_sigwalt.personal_website.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@Document("workExperiences")
public class WorkExperience {

    private int id;
    private String role;
    private String companyName;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String description;
    private List<String> highlights;

    public WorkExperience() {
    }

    public WorkExperience(int id, String role, String companyName, LocalDate dateStart, LocalDate dateEnd, String description, List<String> highlights) {
        this.id = id;
        this.role = role;
        this.companyName = companyName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
        this.highlights = highlights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }
}
