package com.example.checkjwtauth.blog.controller;


import com.example.checkjwtauth.blog.entity.dto.CommentDTO;
import com.example.checkjwtauth.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/check/comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {
    @Autowired
    private CommentService service;

    @GetMapping("/fetchComment/all")
    public ResponseEntity getAll(){

        return ResponseEntity.ok( service.getAll());
    }

    @PostMapping("/save/comment")
    public ResponseEntity createProjectWard(@RequestBody CommentDTO commentDTO){

        CommentDTO commentDTO1 = service.create(commentDTO);
        return  ResponseEntity.ok(commentDTO1.getId());
    }


    @GetMapping("/totalComment/{postId}")
    public  ResponseEntity<List<CommentDTO>> totalLikes(@PathVariable Long postId){

        List<CommentDTO> comments = service.getCommentListByPostId(postId);
        return ResponseEntity.ok(comments);
    }
    @GetMapping("total/userComment/{postId}")
    public ResponseEntity<List<String>> getCommentUserNamesByPostId(@PathVariable Long postId) {
        List<String> likedUserNames = service.getCommentUserNamesByPostId(postId);

        return ResponseEntity.ok(likedUserNames);
    }

    @GetMapping("list/comment/{postId}")
    public  ResponseEntity getCommentListByPostId(@PathVariable Long postId){

        return ResponseEntity.ok(service.getCommentListByPostId(postId));
    }



}
