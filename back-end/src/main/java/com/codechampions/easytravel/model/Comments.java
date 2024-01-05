package com.codechampions.easytravel.model;

import jakarta.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private Integer userId;

    private String text;

    public Comments() {
    }

    public Comments(Integer id, Integer userId, String text) {
        this.id = id;
        this.userId = userId;
        this.text = text;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
