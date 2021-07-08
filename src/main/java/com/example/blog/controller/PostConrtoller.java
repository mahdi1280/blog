package com.example.blog.controller;

import com.example.blog.Repository.PostsRepository;
import com.example.blog.model.dto.PostsDTO;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/post")
public class PostConrtoller {
    private final CategoryService categoryService;
    private final PostsService postsService;

    public PostConrtoller(CategoryService categoryService, PostsService postsRepository) {
        this.categoryService = categoryService;
        this.postsService = postsRepository;
    }

    @GetMapping(value = {"","/"})
    public String create(Model model){
        model.addAttribute("categories" , categoryService.findAll());
        return "postCreate";
    }
    @PostMapping("/add")
    public String add(PostsDTO postsDTO, Principal principal) throws IOException {
        postsService.add(postsDTO,principal.getName());
        return "redirect:/user/alert";
    }
}
