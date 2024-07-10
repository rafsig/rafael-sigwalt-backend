package com.rafael_sigwalt.personal_website.models;

public class About {

    private String firstName;
    private String lastName;
    private String professionalDescription;
    private String personalDescription;
    private Links links;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
