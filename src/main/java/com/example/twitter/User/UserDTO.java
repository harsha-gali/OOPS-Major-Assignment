package com.example.twitter.User;

public class UserDTO {
    private int userID;
    private String name;


        public UserDTO(int userID, String name) {
            this.userID = userID;
            this.name = name;
        }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

