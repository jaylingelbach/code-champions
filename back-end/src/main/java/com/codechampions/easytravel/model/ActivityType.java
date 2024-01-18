package com.codechampions.easytravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ActivityType extends AbstractEntity{

    private String name;

    @ManyToMany(mappedBy = "activityTypes")
    private final List<Activity> activities = new ArrayList<>();

}
