package com.example.checkjwtauth.blog.controller;


import com.example.checkjwtauth.blog.entity.dto.LikeDTO;
import com.example.checkjwtauth.blog.service.LikeService;
import com.example.checkjwtauth.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/check/like")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikeController {

    @Autowired
    private LikeService service;
    @Autowired
    private UserService userService;

    @GetMapping("/fetchLike/all")
    public ResponseEntity getAll(){

        return ResponseEntity.ok( service.getAll());
    }

    @PostMapping("/save/likes")
    public ResponseEntity createProjectWard(@RequestBody LikeDTO likeDTO){

        LikeDTO likeDTO1 = service.create(likeDTO);
        return  ResponseEntity.ok(likeDTO1.getId());
    }

    @GetMapping("/totalLike/{postId}")
    public  ResponseEntity totalLikes(@PathVariable Long postId){

        return  ResponseEntity.ok(service.totalLike(postId));
    }



    @GetMapping("total/userLiked/{postId}")
    public ResponseEntity<List<String>> getLikedUserNamesByPostId(@PathVariable Long postId) {
        List<String> likedUserNames = service.getLikedUserNamesByPostId(postId);
        return ResponseEntity.ok(likedUserNames);
    }
}




