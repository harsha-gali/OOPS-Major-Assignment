package com.example.twitter.comment;

public class CommentEditRequest {
    private String commentBody;
    private int commentID;

    public CommentEditRequest() {
    }

    public CommentEditRequest(String commentBody, int commentID) {
        this.commentBody = commentBody;
        this.commentID = commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }
}

