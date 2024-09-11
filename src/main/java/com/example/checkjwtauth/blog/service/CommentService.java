package com.example.checkjwtauth.blog.service;

import com.example.checkjwtauth.blog.entity.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getAll(

    );

    CommentDTO create(CommentDTO commentDTO);

    int totalComment(Long postId);

    List<String> getCommentUserNamesByPostId(Long postId);

    List<CommentDTO> getCommentListByPostId(Long postId);

    List<CommentDTO> getAlll(

    );
}
