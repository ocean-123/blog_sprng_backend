package com.example.checkjwtauth.blog.service;

import com.example.checkjwtauth.blog.entity.AuthenticationRequest;
import com.example.checkjwtauth.blog.entity.AuthenticationResponse;
import com.example.checkjwtauth.blog.entity.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
