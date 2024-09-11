package com.example.checkjwtauth.blog.repo;

import com.example.checkjwtauth.blog.entity.action.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepo extends JpaRepository<Follower,Long> {


}
