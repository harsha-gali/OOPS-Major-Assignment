package com.example.twitter.comment;

import com.example.twitter.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "Comment-table")
public class Comment {
    @SequenceGenerator(
            name="comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    @Id
    private int commentID;
    private String commentBody;
    @ManyToOne
    @JoinColumn(name="userID",nullable=false)
    private User commentCreator;
    @ManyToOne
    @JoinColumn(name="post_ID",nullable=false)
    private com.example.twitter.post.Post Post;
    /*private int userID;
    /*private String name;*/

    public Comment(String commentBody, User commentCreator, com.example.twitter.post.Post post) {
        this.commentBody = commentBody;
        this.commentCreator = commentCreator;
        Post = post;
    }

    public Comment() {
    }

    public Comment(int commentID, String commentBody, User commentCreator, com.example.twitter.post.Post post) {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.commentCreator = commentCreator;
        Post = post;
    }

    public int getCommentID() {
        return commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public User getCommentCreator() {
        return commentCreator;
    }

    public com.example.twitter.post.Post getPost() {
        return Post;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setCommentCreator(User commentCreator) {
        this.commentCreator = commentCreator;
    }

    public void setPost(com.example.twitter.post.Post post) {
        Post = post;
    }
}
