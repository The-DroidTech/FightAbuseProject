package com.irinnovative.onepagesigninsignup.pojo;

import java.io.Serializable;

/**
 * Created by Code Tribe on 2017/08/18.
 */

public class Place implements Serializable {
    private String name;
    private String desc;
    private int[] imageURl;
    private String address;
    private String website;
    private String telephone;

    public Place() {
    }

    public Place(String name, String desc, int[] imageURl, String address, String website, String telephone) {
        this.name = name;
        this.desc = desc;
        this.imageURl = imageURl;
        this.address = address;
        this.website = website;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int[] getImageURl() {
        return imageURl;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getTelephone() {
        return telephone;
    }
}
