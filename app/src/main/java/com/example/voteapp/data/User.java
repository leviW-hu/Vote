package com.example.voteapp.data;

public class User {

    String profilePicturePath;
    String name;
    String title;

    public User(String profilePicturePath, String name, String title) {
        this.profilePicturePath = profilePicturePath;
        this.name = name;
        this.title = title;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
