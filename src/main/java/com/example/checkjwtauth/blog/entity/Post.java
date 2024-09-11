package com.example.checkjwtauth.blog.entity;


import com.example.checkjwtauth.blog.entity.action.Comment;
import com.example.checkjwtauth.blog.entity.action.Likes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String image_First;
    private String image_Second;
    private String image_Third;


    private String  title;
    private String  description;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Likes> likes;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;







}
