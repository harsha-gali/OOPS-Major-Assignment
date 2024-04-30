package com.example.twitter.User;

public class UserNotFoundResponse {
    private String error;

    public UserNotFoundResponse() {
    }

    public UserNotFoundResponse(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String message) {
        this.error = message;
    }
}
