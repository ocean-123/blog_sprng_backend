package com.example.checkjwtauth.blog.controller;


import com.example.checkjwtauth.blog.entity.dto.PostDTO;
import com.example.checkjwtauth.blog.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@RestController
@RequestMapping("api/check/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    @Autowired
    private PostService service;


    @GetMapping("/fetchPost/all")
    public ResponseEntity<Page<PostDTO>> fetchAll(@RequestParam(defaultValue = "0")int page,
                                                  @RequestParam(defaultValue = "10")int size,
                                                  @RequestParam(defaultValue = "id")String sortBy,
                                                  @RequestParam(defaultValue = "desc")String sortOrder){

        Sort.Direction direction =sortOrder.equalsIgnoreCase("desc")? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size,Sort.by(direction,sortBy));

        Page<PostDTO> post = service.fetchAll(pageable);

        return ResponseEntity.ok(post);

    }
//@Value("${encryption.key}")
//private String encryptionKey;
//
//    @GetMapping("/fetchPost/all")
//    public ResponseEntity<String> fetchAll(@RequestParam(defaultValue = "0") int page,
//                                           @RequestParam(defaultValue = "10") int size,
//                                           @RequestParam(defaultValue = "id") String sortBy,
//                                           @RequestParam(defaultValue = "desc") String sortOrder) {
//        try {
//            Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
//            Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
//            Page<PostDTO> post = service.fetchAll(pageable);
//
//            // Convert post to JSON string
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonData = mapper.writeValueAsString(post);
//
//            // Encrypt the JSON data
//            byte[] encryptedData = encryptData(jsonData.getBytes());
//            String encryptedResponse = Base64.getEncoder().encodeToString(encryptedData);
//            return ResponseEntity.ok(encryptedResponse);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error encrypting data");
//        }
//    }

//    private byte[] encryptData(byte[] data) throws Exception {
//        Cipher cipher = Cipher.getInstance("AES");
//        SecretKeySpec keySpec = new SecretKeySpec(encryptionKey.getBytes(), "AES");
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//        return cipher.doFinal(data);
//    }
    @PostMapping("/save/Post")
    public ResponseEntity<String> savePost(@RequestBody PostDTO postDTO) {
        try {
            service.save(postDTO);
            return ResponseEntity.ok("Post saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }






}
