package com.irinnovative.onepagesigninsignup.pojo;

/**
 * Created by Code Tribe on 2017/09/02.
 */

public class Emergency {
    private String name;
    private String contacts;

    public Emergency() {
    }

    public Emergency(String name, String contacts) {
        this.name = name;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
