package com.example.blog.controller;

import com.example.blog.model.dto.UserDTO;
import com.example.blog.model.entity.Users;
import com.example.blog.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String register(){
        return "RegisterUser";
    }
    @PostMapping(value = "/add")
    public Users add(@RequestBody UserDTO userDTO){
        return userService.add(userDTO);
    }
}
