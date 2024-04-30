package com.example.twitter.post;

import com.example.twitter.User.UserNotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createPost(@RequestBody PostRequest postRequest) {
        String postBody = postRequest.getPostBody();
        int userID = postRequest.getUserID();

        PostCreationResult result = postService.createPost(postBody, userID);

        if (result == PostCreationResult.POST_CREATED_SUCCESSFULLY) {
            return ResponseEntity.ok("Post created successfully");
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PatchMapping("/post")
    public ResponseEntity<Object> editPost(@RequestBody PostEditRequest postEditRequest) {
        String postBody = postEditRequest.getPostBody();
        int postID = postEditRequest.getPostID();

        PostEditResult result = postService.editPost(postID, postBody);

        if (result == PostEditResult.POST_EDITED_SUCCESSFULLY) {
            return ResponseEntity.ok("Post edited successfully");
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/post")
    public ResponseEntity<Object> deletePost(@RequestParam int postID) {
        PostDeletionResult result = postService.deletePost(postID);

        if (result == PostDeletionResult.POST_DELETED_SUCCESSFULLY) {
            return ResponseEntity.ok("Post deleted");
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDTO>> getUserFeed() {
        List<PostDTO> posts = postService.getUserFeed();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/post")
    public ResponseEntity<Object> getPost(@RequestParam int postID) {
        Optional<PostDTO> post = postService.getPost(postID);

        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

