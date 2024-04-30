package com.example.twitter.post;

import com.example.twitter.comment.CommentDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PostDTO {
    private int postID;
    private String postBody;
    private LocalDate date;
    private List<CommentDTO> comments;

    public PostDTO() {
    }

    public PostDTO(int postID, String postBody, LocalDate date, List<CommentDTO> comments) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
    }

    public int getPostID() {
        return postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}

