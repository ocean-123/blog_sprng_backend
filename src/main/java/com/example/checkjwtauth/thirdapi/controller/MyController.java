package com.example.checkjwtauth.thirdapi.controller;

import com.example.checkjwtauth.thirdapi.service.ThirdPartyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MyController {

    private final ThirdPartyService thirdPartyService;

    public MyController(ThirdPartyService thirdPartyService) {
        this.thirdPartyService = thirdPartyService;
    }

    @GetMapping("/data")
    public ResponseEntity<String> getDataFromThirdParty() {
        try {
            String responseData = thirdPartyService.callThirdPartyApi();
            return ResponseEntity.ok(responseData);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while calling the third-party API.");
        }
    }
}
