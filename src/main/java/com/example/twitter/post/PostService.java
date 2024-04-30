package com.example.twitter.post;
import com.example.twitter.User.UserDTO;
import com.example.twitter.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.twitter.User.User;
import com.example.twitter.comment.CommentDTO;
import com.example.twitter.comment.Comment;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostCreationResult createPost(String postBody, int userID) {
        User user = userRepository.findById(userID).orElse(null);

        if (user != null) {
            Date t= new Date();
            Post post = new Post(postBody,t,user);
            postRepository.save(post);
            return PostCreationResult.POST_CREATED_SUCCESSFULLY;
        } else {
            return PostCreationResult.USER_NOT_FOUND;
        }
    }
    public PostEditResult editPost(int postID, String postBody) {
        Optional<Post> optionalPost = postRepository.findBypostID(postID);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setPostBody(postBody);
            postRepository.save(post);
            return PostEditResult.POST_EDITED_SUCCESSFULLY;
        } else {
            return PostEditResult.POST_NOT_FOUND;
        }
    }

    public PostDeletionResult deletePost(int postID) {
        Optional<Post> optionalPost = postRepository.findBypostID(postID);

        if (optionalPost.isPresent()) {
            postRepository.deleteById(postID);
            return PostDeletionResult.POST_DELETED_SUCCESSFULLY;
        } else {
            return PostDeletionResult.POST_NOT_FOUND;
        }
    }
    public List<PostDTO> getUserFeed() {
        List<Post> posts = postRepository.findAllByOrderByDateDesc();
        return convertToDTO(posts);
    }

    private List<PostDTO> convertToDTO(List<Post> posts) {
        List<PostDTO> postDTOs = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Post post : posts) {
            PostDTO postDTO = new PostDTO();
            postDTO.setPostID(post.getPostID());
            postDTO.setPostBody(post.getPostBody());
            LocalDate localDate = post.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            postDTO.setDate(localDate);
            postDTO.setComments(convertCommentsToDTO(post.getComments()));
            postDTOs.add(postDTO);
        }

        return postDTOs;
    }

    private List<CommentDTO> convertCommentsToDTO(List<Comment> comments) {
        List<CommentDTO> commentDTOs = new ArrayList<>();

        for (Comment comment : comments) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setCommentID(comment.getCommentID());
            commentDTO.setCommentBody(comment.getCommentBody());

            User user = comment.getCommentCreator();
            UserDTO userDTO = new UserDTO(user.getUserID(), user.getName());
            commentDTO.setCommentCreator(userDTO);

            commentDTOs.add(commentDTO);
        }

        return commentDTOs;
    }

    public Optional<PostDTO> getPost(int postID) {
        Optional<Post> post = postRepository.findById(postID);

        if (post.isPresent()) {
            List<Post> posts = new ArrayList<>();
            posts.add(post.get());
            List<PostDTO> temp = convertToDTO(posts);
            return Optional.of(temp.get(0));
        } else {
            return Optional.empty();
        }
    }
}

