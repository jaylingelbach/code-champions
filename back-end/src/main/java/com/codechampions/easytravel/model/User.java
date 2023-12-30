package com.codechampions.easytravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.awt.*;


@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

//    private Image avatar;

    public User() {
    }

    public User(Integer id, String userName, String email, String firstName, String lastName, String password, Image avatar) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
//        this.avatar = avatar;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Image getAvatar() {
//        return avatar;
//    }

//    public void setAvatar(Image avatar) {
//        this.avatar = avatar;
//    }
}
