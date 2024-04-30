package com.example.twitter.comment;

import com.example.twitter.User.User;
import com.example.twitter.User.UserDTO;
import com.example.twitter.User.UserRepository;
import com.example.twitter.post.Post;
import com.example.twitter.post.PostRepository;
import com.example.twitter.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public CommentCreationResult createComment(String commentBody, int postID, int userID) {
        Optional<Post> optionalPost = postRepository.findBypostID(postID);
        Optional<User> optionalUser = userRepository.findByuserID(userID);

        if (optionalPost.isPresent()) {
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                Post post = optionalPost.get();

                Comment comment = new Comment(commentBody, user, post);
                commentRepository.save(comment);

                return CommentCreationResult.COMMENT_CREATED_SUCCESSFULLY;
            } else {
                return CommentCreationResult.USER_NOT_FOUND;
            }
        } else {
            return CommentCreationResult.POST_NOT_FOUND;
        }
    }

    public CommentEditResult editComment(int commentID, String commentBody) {
        Optional<Comment> optionalComment = commentRepository.findBycommentID(commentID);

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setCommentBody(commentBody);
            commentRepository.save(comment);
            return CommentEditResult.COMMENT_EDITED_SUCCESSFULLY;
        } else {
            return CommentEditResult.COMMENT_NOT_FOUND;
        }
    }
    public CommentDeletionResult deleteComment(int commentID) {
        Optional<Comment> optionalComment = commentRepository.findBycommentID(commentID);

        if (optionalComment.isPresent()) {
            commentRepository.deleteById(commentID);
            return CommentDeletionResult.COMMENT_DELETED_SUCCESSFULLY;
        } else {
            return CommentDeletionResult.COMMENT_NOT_FOUND;
        }
    }

    public Optional<CommentDTO> getComment(int commentID) {
        Optional<Comment> comment = commentRepository.findById(commentID);

        if (comment.isPresent()) {
            return Optional.of(convertToDTO(comment.get()));
        } else {
            return Optional.empty();
        }
    }


    private CommentDTO convertToDTO(Comment comment) {

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentID(comment.getCommentID());
        commentDTO.setCommentBody(comment.getCommentBody());
        User user = comment.getCommentCreator();
        UserDTO userDTO = new UserDTO(user.getUserID(), user.getName());
        commentDTO.setCommentCreator(userDTO);

        return commentDTO;
    }
}

