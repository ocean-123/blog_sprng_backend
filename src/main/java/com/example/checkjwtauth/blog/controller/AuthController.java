package com.example.checkjwtauth.blog.controller;


import com.example.checkjwtauth.blog.entity.AuthenticationRequest;
import com.example.checkjwtauth.blog.entity.AuthenticationResponse;
import com.example.checkjwtauth.blog.entity.RegisterRequest;
import com.example.checkjwtauth.blog.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/check/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class AuthController {
    @Autowired
    private AuthenticationService service;

//    @GetMapping("/login")
//    public String loginPage(){
//        return "login";
//    }
//
//    @GetMapping("/signup")
//    public String registerPage(){
//        return "signup";
//    }

//    @PostMapping("/register")
//    public  String register(@RequestBody RegisterRequest request){
//      AuthenticationResponse response= service.register(request);
//        return "redirect:/api/check/auth/login";
//
//    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
      return   ResponseEntity.ok(service.register(request)) ;


    }

//    @PostMapping("/authenticate")
//    public  String  register(@RequestBody AuthenticationRequest request){
//        AuthenticationResponse response = service.authenticate(request);
//        return "redirect:/api/check/user/message";
//
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return   ResponseEntity.ok(service.authenticate(request)) ;


    }
}

