package com.example.checkjwtauth.blog.entity.action;


import com.example.checkjwtauth.blog.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "follower")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @JoinColumn(referencedColumnName = "id",name = "follower")
//    @ManyToOne
//    private User userFollower;
//    @JoinColumn(referencedColumnName = "id",name = "following")
//    @ManyToOne
//    private User userFollowing ;

}

