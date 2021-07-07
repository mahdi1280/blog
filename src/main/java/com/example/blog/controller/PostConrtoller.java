package com.example.blog.controller;

import com.example.blog.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostConrtoller {
    private final CategoryService categoryService;

    public PostConrtoller(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = {"","/"})
    public String create(Model model){
        model.addAttribute("categories" , categoryService.findAll());
        return "postCreate";
    }
}
