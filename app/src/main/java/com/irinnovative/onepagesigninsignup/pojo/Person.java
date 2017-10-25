package com.irinnovative.onepagesigninsignup.pojo;

/**
 * Created by Code Tribe on 2017/09/18.
 */

public class Person {
    private String id, username, bio, cellphone, imageUrl;

    public Person() {
    }

    public Person(String id, String username, String bio, String cellphone, String imageUrl) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.cellphone = cellphone;
        this.imageUrl = imageUrl;
    }

    public Person(String id, String username, String bio, String cellphone) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.cellphone = cellphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
