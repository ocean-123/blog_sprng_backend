package com.example.checkjwtauth.blog.service.impl;

import com.example.checkjwtauth.blog.entity.User;
import com.example.checkjwtauth.blog.entity.dto.dtoConverter.DtoConverter;
import com.example.checkjwtauth.blog.entity.dto.PostDTO;
import com.example.checkjwtauth.blog.repo.PostRepo;
import com.example.checkjwtauth.blog.entity.Post;
import com.example.checkjwtauth.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo repo;



    @Override
    public Page<PostDTO> fetchAll(Pageable pageable) {

        Page<Post> posts = repo.findAll(pageable);
        return  posts.map(post -> DtoConverter.convert(post,post.getUser().getName())) ;
    }


    public void save(PostDTO postDTO) {
        Post post = DtoConverter.convert(postDTO);
        repo.save(post);
    }
}
