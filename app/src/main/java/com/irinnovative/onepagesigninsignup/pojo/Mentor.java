package com.irinnovative.onepagesigninsignup.pojo;

import java.io.Serializable;

/**
 * Created by Code Tribe on 2017/09/01.
 */

public class Mentor implements Serializable{

    private String name;
    private String intitution;
    private String description;
    private String contacts;
    private String website;
    private String email;
    private int image = -1;

    public Mentor() {
    }

    public Mentor(String name, String intitution, int image) {
        this.name = name;
        this.intitution = intitution;
        this.image = image;
    }

    public Mentor(String name, String intitution, String description, String contacts, String website,String email, int image) {
        this.name = name;
        this.intitution = intitution;
        this.description = description;
        this.contacts = contacts;
        this.website = website;
        this.image = image;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntitution() {
        return intitution;
    }

    public void setIntitution(String intitution) {
        this.intitution = intitution;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
