package com.codechampions.easytravel.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Activity extends AbstractEntity{

    @ManyToOne
    private User user;
    private String event_name;
    private String event_description;
    private Float cost;
    private String location;
    private String start_date;
    private String end_date;

    @ManyToMany
    private List<ActivityType> activityTypes;

    @ManyToMany
    private List<Operator> operators;

    public Activity(String event_name, String event_description, Float cost, String location, String start_date, String end_date, List<ActivityType> activityTypes, List<Operator> operators) {
        this.event_name = event_name;
        this.event_description = event_description;
        this.cost = cost;
        this.location = location;
        this.start_date = start_date;
        this.end_date = end_date;
        this.activityTypes = activityTypes;
        this.operators = operators;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}