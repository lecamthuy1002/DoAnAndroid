package com.example.doanandroid.ui.room;

import java.io.Serializable;

public class Room implements Serializable {
    private String name;
    private String ratings;
    private String visits;
    private String completedBookings;
    private String draftBookings;
    private String tags;
    private String description;
    private int imageUrl;

    public Room(String name, String ratings, String visits, String completedBookings, String draftBookings, String tags, String description, int imageUrl) {
        this.name = name;
        this.ratings = ratings;
        this.visits = visits;
        this.completedBookings = completedBookings;
        this.draftBookings = draftBookings;
        this.tags = tags;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public String getCompletedBookings() {
        return completedBookings;
    }

    public void setCompletedBookings(String completedBookings) {
        this.completedBookings = completedBookings;
    }

    public String getDraftBookings() {
        return draftBookings;
    }

    public void setDraftBookings(String draftBookings) {
        this.draftBookings = draftBookings;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

}

