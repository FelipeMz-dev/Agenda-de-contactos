package com.mz_dev.agendadecontactos;

import java.io.Serializable;

public class Contact implements Serializable {
    private String fullName;
    private String birthDate;
    private String telephone;
    private String email;
    private String description;

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Contact(String fullName, String birthDate, String telephone, String email, String description) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
    }
}
