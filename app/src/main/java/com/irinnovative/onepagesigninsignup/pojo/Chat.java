package com.irinnovative.onepagesigninsignup.pojo;



public class Chat
{
    private String roomName;
    private String userName;
    private String message;


    public Chat(String roomName, String userName) {
        this.roomName = roomName;
        this.userName = userName;
    }


    public Chat(String roomName) {
        this.roomName = roomName;
    }

    public Chat(String roomName, String userName, String message) {
        this.roomName = roomName;
        this.userName = userName;
        this.message = message;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
