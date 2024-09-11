package com.example.checkjwtauth.blog.repo;

import com.example.checkjwtauth.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);

    List<String> findNameById(Long Id);
}
