package com.codechampions.easytravel.model;

import jakarta.persistence.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Itinerary {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    private List<Activity> activityList = new ArrayList<>();

    @OneToMany
    private List<Comments> commentsList = new ArrayList<>();

    public Itinerary() {
    }

    public Itinerary(Integer id, List<Activity> activityList, List<Comments> commentsList) {
        this.id = id;
        this.activityList = activityList;
        this.commentsList = commentsList;
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

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }
}
