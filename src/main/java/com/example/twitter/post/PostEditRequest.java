package com.example.twitter.post;

public class PostEditRequest {
    private String postBody;
    private int postID;

    public PostEditRequest(String postBody, int postID) {
        this.postBody = postBody;
        this.postID = postID;
    }

    public PostEditRequest() {
    }

    public String getPostBody() {
        return postBody;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }
}

