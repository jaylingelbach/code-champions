package com.codechampions.easytravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Operator extends AbstractEntity{

    private String name;

    private String email;

    @ManyToMany(mappedBy = "operators")
    private final List<Activity> activities = new ArrayList<>();

    public Operator() {}

    public Operator(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
