package com.example.checkjwtauth.blog.repo;

import com.example.checkjwtauth.blog.entity.action.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    int countByPostId(Long postId);

    List<Comment> findByPostId(Long postId);

    List<Comment> findCommentsByPostId(Long postId);

}
