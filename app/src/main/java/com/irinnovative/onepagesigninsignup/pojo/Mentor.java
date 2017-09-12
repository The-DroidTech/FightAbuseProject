package com.irinnovative.onepagesigninsignup.pojo;

/**
 * Created by Code Tribe on 2017/09/01.
 */

public class Mentor {

    private String name;
    private String intitution;
    private int image = -1;

    public Mentor() {
    }

    public Mentor(String name, String intitution, int image) {
        this.name = name;
        this.intitution = intitution;
        this.image = image;
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
}
