package com.example.twitter.comment;

import com.example.twitter.User.UserNotFoundResponse;
import com.example.twitter.post.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseEntity<Object> createComment(@RequestBody CommentRequest commentRequest) {
        String commentBody = commentRequest.getCommentBody();
        int postID = commentRequest.getPostID();
        int userID = commentRequest.getUserID();

        CommentCreationResult result = commentService.createComment(commentBody, postID, userID);

        if (result == CommentCreationResult.COMMENT_CREATED_SUCCESSFULLY) {
            return ResponseEntity.ok("Comment created successfully");
        } else if (result == CommentCreationResult.USER_NOT_FOUND) {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PatchMapping("/comment")
    public ResponseEntity<Object> editComment(@RequestBody CommentEditRequest commentEditRequest) {
        String commentBody = commentEditRequest.getCommentBody();
        int commentID = commentEditRequest.getCommentID();

        CommentEditResult result = commentService.editComment(commentID, commentBody);

        if (result == CommentEditResult.COMMENT_EDITED_SUCCESSFULLY) {
            return ResponseEntity.ok("Comment edited successfully");
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/comment")
    public ResponseEntity<Object> deleteComment(@RequestParam int commentID) {
        CommentDeletionResult result = commentService.deleteComment(commentID);

        if (result == CommentDeletionResult.COMMENT_DELETED_SUCCESSFULLY) {
            return ResponseEntity.ok("Comment deleted");
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/comment")
    public ResponseEntity<Object> getComment(@RequestParam int commentID) {
        Optional<CommentDTO> comment = commentService.getComment(commentID);

        if (comment.isPresent()) {
            return ResponseEntity.ok(comment.get());
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

