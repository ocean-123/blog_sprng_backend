package com.example.checkjwtauth.blog.controller;


import com.example.checkjwtauth.blog.entity.User;
import com.example.checkjwtauth.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/check/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

    @Autowired
     private UserService service;

    @GetMapping("/message")
    public ResponseEntity message(){
        return ResponseEntity.ok("I Love Java");

    }

    @PostMapping
    public  ResponseEntity create_Blog(User user){
        User user1 = service.create(user);
        return ResponseEntity.ok(user1.getUsername());
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.fetchAll());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editProject(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(service.updateProject(id, user));


    }

        @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }


}
