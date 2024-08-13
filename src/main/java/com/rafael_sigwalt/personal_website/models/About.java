package com.rafael_sigwalt.personal_website.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("about")
public class About {

    @Id
    private Integer id;
    private String imageUrl;
    private String professionalDescription;
    private String personalDescription;
    private Links links;

    public About() {
    }

    public About(Integer id, String imageUrl, String professionalDescription, String personalDescription, Links links) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.professionalDescription = professionalDescription;
        this.personalDescription = personalDescription;
        this.links = links;
    }

    public String getProfessionalDescription() {
        return professionalDescription;
    }

    public void setProfessionalDescription(String professionalDescription) {
        this.professionalDescription = professionalDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
