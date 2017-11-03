package com.irinnovative.onepagesigninsignup.pojo;

/**
 * Created by codetribe on 01/11/2017.
 */

public class ChatRoom {

    private String roomName,roomDescription;

    public ChatRoom() {
    }

    public ChatRoom(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
}
