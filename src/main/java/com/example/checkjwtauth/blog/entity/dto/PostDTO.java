package com.example.checkjwtauth.blog.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostDTO {


    private Long id;

    private String image_First;
    private String image_Second;
    private String image_Third;


    private String  Title;
    private String  Description;


    private long userId;
private String name;

}
