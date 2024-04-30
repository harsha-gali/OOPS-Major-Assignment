package com.example.twitter.post;

import com.example.twitter.User.User;
import com.example.twitter.comment.Comment;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Post-table")
public class Post {
    @SequenceGenerator(
            name="post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    @Id
    private int postID;
    private String postBody;
    private Date date;
    @OneToMany(mappedBy = "Post", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments;
    @ManyToOne
    @JoinColumn(name ="userID",nullable = false)
    private User user;
    public Post() {
    }

    public Post(int postID, String postBody, Date date, List<Comment> comments, User user) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
        this.user = user;
    }

    public Post(String postBody, Date date, List<Comment> comments, User user) {
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
        this.user = user;
    }

    public Post(String postBody, Date date, User user) {
        this.postBody = postBody;
        this.date = date;
        this.user = user;
    }

    public int getPostID() {
        return postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public Date getDate() {
        return date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public User getUser() {
        return user;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
