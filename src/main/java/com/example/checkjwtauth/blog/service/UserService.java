package com.example.checkjwtauth.blog.service;

import com.example.checkjwtauth.blog.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> fetchAll();

    User updateProject(Long id, User user);

    Boolean deleteById(Long id);
    public User findById(Long userId);


}
