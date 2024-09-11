package com.example.checkjwtauth.blog.service.impl;

import com.example.checkjwtauth.blog.entity.action.Comment;
import com.example.checkjwtauth.blog.entity.action.Likes;
import com.example.checkjwtauth.blog.entity.dto.CommentDTO;
import com.example.checkjwtauth.blog.entity.dto.dtoConverter.DtoConverter;
import com.example.checkjwtauth.blog.repo.CommentRepo;
import com.example.checkjwtauth.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl  implements CommentService {
    @Autowired
    private CommentRepo repo;

    @Override
    public List<CommentDTO> getAll() {
        return repo.findAll().stream().map(DtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public CommentDTO create(CommentDTO commentDTO) {
        Comment comment = DtoConverter.convert(commentDTO);
        comment = repo.save(comment);
        return DtoConverter.convert(comment);
    }

    @Override
    public int totalComment(Long postId) {
        return repo.countByPostId(postId);
    }

    @Override
    public List<String> getCommentUserNamesByPostId(Long postId) {
        List<Comment> comments = repo.findByPostId(postId);
        return comments.stream()
                .map(like -> like.getUser().getName())
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getCommentListByPostId(Long postId) {
        return repo.findCommentsByPostId(postId).stream().map(DtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getAlll() {
        return null;
    }

}
