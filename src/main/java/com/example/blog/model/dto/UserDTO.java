package com.example.blog.model.dto;

import com.example.blog.model.entity.Posts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class UserDTO {

    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
