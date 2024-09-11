package com.example.checkjwtauth.blog.repo;

import com.example.checkjwtauth.blog.entity.action.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepo extends JpaRepository<Likes,Long> {

    int countByPostId(Long postId);

    List<Long> findUserIdsByPostId(Long postId);

    List<Likes> findByPostId(Long postId);
}
