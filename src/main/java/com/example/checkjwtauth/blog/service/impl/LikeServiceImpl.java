package com.example.checkjwtauth.blog.service.impl;

import com.example.checkjwtauth.blog.entity.action.Likes;
import com.example.checkjwtauth.blog.entity.dto.LikeDTO;
import com.example.checkjwtauth.blog.entity.dto.dtoConverter.DtoConverter;
import com.example.checkjwtauth.blog.repo.LikeRepo;
import com.example.checkjwtauth.blog.repo.UserRepo;
import com.example.checkjwtauth.blog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepo repo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<LikeDTO> getAll() {
        return repo.findAll().stream().map(DtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public LikeDTO create(LikeDTO likeDTO) {
        Likes like = DtoConverter.convert(likeDTO);
        like = repo.save(like);
        return DtoConverter.convert(like);
    }

    @Override
    public int totalLike(Long postId) {

        return repo.countByPostId(postId);
    }

    @Override
    public List<String> getUsernamesWhoLikedPost(Long postId) {
        return null;
    }

    @Override
    public List<Long> getUsersWhoLikedPost(Long postId) {
        return repo.findUserIdsByPostId(postId);
    }

    @Override
    public List<String> getLikedUserNamesByPostId(Long postId) {
        List<Likes> likes = repo.findByPostId(postId);
        return likes.stream()
                .map(like -> like.getUser().getName())
                .collect(Collectors.toList());
    }
    }

//    @Override
//    public List<String> getUsernamesWhoLikedPost(Long postId) {
//        List<Long> userIds = repo.findUserIdsByPostId(postId);
//        return userRepo.findNameById(userIds);
//    }


