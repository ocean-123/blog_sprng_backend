package com.example.checkjwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckJwtAuthApplication {

    public static void main(String[] args) {

                System.out.println("JDK version: " + System.getProperty("java.version"));


        SpringApplication.run(CheckJwtAuthApplication.class, args);
    }

}
