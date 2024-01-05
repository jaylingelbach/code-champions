package com.codechampions.easytravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.NotNull;

@Entity
public class UserProfile extends AbstractEntity{

    @NotNull
    private String email;

    @NotNull
    private String bio;

    public UserProfile(String email, String bio) {
        this.email = email;
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }
    public String getBio() {
        return bio;
    }


}
