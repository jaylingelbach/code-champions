package com.codechampions.easytravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Itinerary {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    private List<Activity> activityList = new ArrayList<>();

    public Itinerary() {
    }

    public Itinerary(Integer id, List<Activity> activityList) {
        this.id = id;
        this.activityList = activityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
