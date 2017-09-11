package com.irinnovative.onepagesigninsignup.pojo;

import java.io.Serializable;

/**
 * Created by Code Tribe on 2017/09/02.
 */

public class Abuse implements Serializable{
    private String topic;
    private String desc;
    private int img;

    public Abuse() {
    }

    public Abuse(String topic, String desc, int img) {
        this.topic = topic;
        this.desc = desc;
        this.img = img;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
