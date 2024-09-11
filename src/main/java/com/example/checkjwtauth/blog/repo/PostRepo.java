package com.example.checkjwtauth.blog.repo;

import com.example.checkjwtauth.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Long> {
}
