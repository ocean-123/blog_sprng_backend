package com.example.checkjwtauth.blog.service;

import com.example.checkjwtauth.blog.entity.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    List<LikeDTO> getAll();

    LikeDTO create(LikeDTO likeDTO);

    int totalLike(Long postId);

    List<String> getUsernamesWhoLikedPost(Long postId);

    List<Long> getUsersWhoLikedPost(Long postId);

    List<String> getLikedUserNamesByPostId(Long postId);
}
