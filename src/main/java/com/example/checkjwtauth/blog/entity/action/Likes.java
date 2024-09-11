package com.example.checkjwtauth.blog.entity.action;


import com.example.checkjwtauth.blog.entity.Post;
import com.example.checkjwtauth.blog.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private Long like;
//    private String comments;


    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private User user;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private Post post;
}
