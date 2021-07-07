package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
        SpringApplication.run(BlogApplication.class, args);
    }

}
