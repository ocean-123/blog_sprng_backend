package com.example.checkjwtauth.blog.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class LikeDTO {


    private Long id;


    private long userId;


    private long postId;
}
