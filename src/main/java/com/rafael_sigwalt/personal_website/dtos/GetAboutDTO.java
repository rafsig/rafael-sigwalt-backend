package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.About;
import com.rafael_sigwalt.personal_website.models.Links;

public class GetAboutDTO {
    private String professionalDescription;
    private String personalDescription;
    private Links links;

    public GetAboutDTO(About about) {
        professionalDescription = about.getProfessionalDescription();
        personalDescription = about.getPersonalDescription();
        links = about.getLinks();
    }

    public String getProfessionalDescription() {
        return professionalDescription;
    }

    public void setProfessionalDescription(String professionalDescription) {
        this.professionalDescription = professionalDescription;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public void setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
