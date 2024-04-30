package com.example.twitter.User;

public class UsersDTO {
    private String name;
    private int userID;
    private String email;

    public UsersDTO(String name, int userID, String email) {
        this.name = name;
        this.userID = userID;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
