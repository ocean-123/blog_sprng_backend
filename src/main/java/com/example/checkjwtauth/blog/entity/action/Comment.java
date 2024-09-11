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
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comments;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private User user;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private Post post;

}
