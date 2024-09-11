package com.example.checkjwtauth.blog.service;

import com.example.checkjwtauth.blog.entity.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<PostDTO> fetchAll(Pageable pageable);

    void save(PostDTO postDTO);
}
