package com.example.checkjwtauth.blog.entity.dto.dtoConverter;

import com.example.checkjwtauth.blog.entity.Post;
import com.example.checkjwtauth.blog.entity.User;
import com.example.checkjwtauth.blog.entity.action.Comment;
import com.example.checkjwtauth.blog.entity.action.Follower;
import com.example.checkjwtauth.blog.entity.action.Likes;
import com.example.checkjwtauth.blog.entity.dto.CommentDTO;
import com.example.checkjwtauth.blog.entity.dto.FollowerDTO;
import com.example.checkjwtauth.blog.entity.dto.LikeDTO;
import com.example.checkjwtauth.blog.entity.dto.PostDTO;

public class DtoConverter {



    public  static PostDTO convert(Post  entity, String name){
        PostDTO dto= new PostDTO();
        dto.setId(entity.getId());

        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setImage_First(entity.getImage_First());
        dto.setImage_Second(entity.getImage_Second());
        dto.setImage_Third(entity.getImage_Third());
        dto.setUserId(entity.getUser().getId());
        dto.setName(name);


        return dto;

    }


    public static  Post convert(PostDTO dto){

        Post entity = new Post();
//entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setImage_First(dto.getImage_First());
        entity.setImage_Second(dto.getImage_Second());
        entity.setImage_Third(dto.getImage_Third());

        User user = new User();
        user.setId(dto.getUserId());
        entity.setUser(user);
        return entity;
    }


    public  static Likes convert(LikeDTO dto){

        Likes entity = new Likes();

        User user = new User();
        user.setId(dto.getUserId());
        entity.setUser(user);

        Post post = new Post();
        post.setId(dto.getPostId());
        entity.setPost(post);

        return entity;
    }

    public static  LikeDTO convert(Likes entity){

        LikeDTO dto = new LikeDTO();

        dto.setId(entity.getId());
        dto.setPostId(entity.getPost().getId());
        dto.setUserId(entity.getUser().getId());

        return dto;

    }
    public  static Comment convert(CommentDTO dto){

        Comment entity = new Comment();


        entity.setComments(dto.getComments());

        User user = new User();
        user.setId(dto.getUserId());
        entity.setUser(user);

        Post post = new Post();
        post.setId(dto.getPostId());
        entity.setPost(post);

        return entity;
    }

    public static  CommentDTO convert(Comment entity){

        CommentDTO dto = new CommentDTO();

        dto.setId(entity.getId());
        dto.setComments(entity.getComments());
        dto.setPostId(entity.getPost().getId());
        dto.setUserId(entity.getUser().getId());

        return dto;


    }

//    public static Follower convert(FollowerDTO dto){
//
//        Follower entity = new Follower();
//
//
//        User user = new User();
//        user.setId(dto.getUserFollowerId());
//        entity.setUserFollower(user);
//        User user1 = new User();
//        user1.setId(dto.getUserFollowingId());
//        entity.setUserFollower(user1);
//
//        return  entity;
//
//    }
//
//    public  static  FollowerDTO convert(Follower entity){
//
//        FollowerDTO dto = new FollowerDTO();
//        dto.setId(entity.getId());
//        dto.setUserFollowerId(entity.getUserFollower().getId());
//        dto.setUserFollowingId(entity.getUserFollowing().getId());
//
//        return dto;
//    }





}
