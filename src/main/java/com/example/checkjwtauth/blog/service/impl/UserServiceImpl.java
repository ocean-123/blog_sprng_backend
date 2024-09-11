package com.example.checkjwtauth.blog.service.impl;


import com.example.checkjwtauth.blog.entity.User;
import com.example.checkjwtauth.blog.repo.UserRepo;
import com.example.checkjwtauth.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public User updateProject(Long id, User user) {
        return null ;
    }

    @Override
    public Boolean deleteById(Long id) {
        userRepo.deleteById(id);

        return true;
    }
    public User findById(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        return userOptional.orElse(null); // Return null if user is not found
    }


}
