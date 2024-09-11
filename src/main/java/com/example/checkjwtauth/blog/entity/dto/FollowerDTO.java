package com.example.checkjwtauth.blog.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FollowerDTO {

    private  Long id;


    private long userFollowerId;

    private long userFollowingId;
}
