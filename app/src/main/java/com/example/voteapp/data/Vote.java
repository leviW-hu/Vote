package com.example.voteapp.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Vote {

    private String imgPath;
    private MyLocation location;
    private String title;
    private String text;
    private boolean active;
    private LocalDateTime deadline;
    private User creator;

    public Vote(String imgPath, MyLocation location, String text, boolean active, LocalDateTime deadline, User creator, String title) {
        this.imgPath = imgPath;
        this.title = title;
        this.location = location;
        this.text = text;
        this.active = active;
        this.deadline = deadline;
        this.creator = creator;
    }


    public String getImgPath() {
        return imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public MyLocation getLocation() {
        return location;
    }

    public void setLocation(MyLocation location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getMonthAndDay(){
        return deadline.getMonth().toString() + ", " + Integer.toString(deadline.getDayOfMonth());
    }
}

