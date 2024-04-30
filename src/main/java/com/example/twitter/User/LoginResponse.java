package com.example.twitter.User;

public class LoginResponse {
    private String error;

    public LoginResponse(String error) {
        this.error = error;
    }

    public LoginResponse() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

