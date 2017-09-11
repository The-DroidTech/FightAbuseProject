package com.irinnovative.onepagesigninsignup.pojo;

/**
 * Created by Code Tribe on 2017/09/02.
 */

public class Sos {
    private int sos_id;
    private String contact1;
    private String contact2;
    private String contact3;
    private String message;

    public Sos() {
    }

    public Sos(int sos_id, String contact1, String contact2, String contact3, String message) {
        this.sos_id = sos_id;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.contact3 = contact3;
        this.message = message;
    }

    public Sos(String contact1, String contact2, String contact3, String message) {
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.contact3 = contact3;
        this.message = message;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getContact3() {
        return contact3;
    }

    public void setContact3(String contact3) {
        this.contact3 = contact3;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSos_id() {
        return sos_id;
    }

    public void setSos_id(int sos_id) {
        this.sos_id = sos_id;
    }
}
