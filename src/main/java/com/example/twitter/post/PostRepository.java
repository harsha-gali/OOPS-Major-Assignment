package com.example.twitter.post;
import com.example.twitter.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findBypostID(int postID);
    List<Post> findAllByOrderByDateDesc();
}

