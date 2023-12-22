package org.launchode.easyTravel.models;

import java.time.LocalDate;

public class User {

    private static int nextId = 1;

    private final int id;
    private String username;
    private String email;
    private String password;

    private String firstname;

    private String lastname;

    private String address;

    private String phonenumber;
    private final LocalDate dateRegistered;

    public User(String username, String email, String password, String firstname, String lastname, String address, String phonenumber) {
        this.id = nextId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.dateRegistered = LocalDate.now();
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }
}
