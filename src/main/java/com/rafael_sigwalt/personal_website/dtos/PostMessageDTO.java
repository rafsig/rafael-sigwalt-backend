package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.Message;
import jakarta.validation.constraints.NotBlank;

public class PostMessageDTO {

    @NotBlank
    private String message;

    @NotBlank
    private String email;

    @NotBlank
    private String fullName;

    private String company;

    public Message getMessage(){
        return new Message(message, email, fullName, company);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
