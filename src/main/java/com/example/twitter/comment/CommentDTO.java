package com.example.twitter.comment;

import com.example.twitter.User.UserDTO;

public class CommentDTO {
    private int commentID;
    private String commentBody;
    private UserDTO commentCreator;

    public CommentDTO(String commentBody, int commentID, UserDTO commentCreator) {
        this.commentBody = commentBody;
        this.commentID = commentID;
        this.commentCreator = commentCreator;
    }

    public CommentDTO() {
    }

    public int getCommentID() {
        return commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public UserDTO getCommentCreator() {
        return commentCreator;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setCommentCreator(UserDTO commentCreator) {
        this.commentCreator = commentCreator;
    }
}
