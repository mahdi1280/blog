package com.example.blog.controller;

import com.example.blog.service.PostsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final PostsService postsService;

    public MainController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/index")
    public String index(Model model, Pageable pageable) {
        model.addAttribute("file" , postsService.show(pageable));
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String loginSave() {
        return "login";
    }
    @GetMapping("/deni")
    public String deni(){
        return "access";
    }

}
