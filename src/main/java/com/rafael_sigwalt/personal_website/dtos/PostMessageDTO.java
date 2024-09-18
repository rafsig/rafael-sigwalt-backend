package com.rafael_sigwalt.personal_website.dtos;

import com.rafael_sigwalt.personal_website.models.Message;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class PostMessageDTO {

    @NotBlank
    @Length(max = 200)
    private String message;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
    @Length(max = 50)
    private String email;

    @NotBlank
    @Length(max = 50)
    private String fullName;

    @Length(max = 50)
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
