package com.example.myfirstapplication.app.inquiry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InquiryForm {
    @Size(min = 1, max = 20, message = "please input 20characters or less")
    private String name;

    @NotNull
    @Email(message = "Invalid E-mail Format")
    private String email;

    @NotNull
    private String contens;

    public InquiryForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContens() {
        return contens;
    }

    public void setContens(String contens) {
        this.contens = contens;
    }
}
