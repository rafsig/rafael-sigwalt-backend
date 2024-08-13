package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.WorkExperience;

import java.time.LocalDate;
import java.util.List;

public class GetWorkExperienceDTO {

    private int id;
    private String role;
    private String companyName;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String description;
    private List<String> highlights;

    public GetWorkExperienceDTO(WorkExperience workExperience) {
        id = workExperience.getId();
        role = workExperience.getRole();
        companyName = workExperience.getCompanyName();
        dateStart = workExperience.getDateStart();
        dateEnd = workExperience.getDateEnd();
        description = workExperience.getDescription();
        highlights = workExperience.getHighlights();
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
