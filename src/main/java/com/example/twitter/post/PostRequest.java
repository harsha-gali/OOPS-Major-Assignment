package com.example.twitter.post;

public class PostRequest {
    private String postBody;
    private int userID;

    public PostRequest() {
    }

    public PostRequest(String postBody, int userID) {
        this.postBody = postBody;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
