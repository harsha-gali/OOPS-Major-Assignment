package com.example.twitter.comment;

public class CommentRequest {
    private String commentBody;
    private int postID;
    private int userID;

    public CommentRequest(String commentBody, int postID, int userID) {
        this.commentBody = commentBody;
        this.postID = postID;
        this.userID = userID;
    }

    public CommentRequest() {
    }

    public String getCommentBody() {
        return commentBody;
    }

    public int getPostID() {
        return postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

