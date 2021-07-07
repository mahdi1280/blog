package com.example.blog.controller;

import com.example.blog.model.dto.CategoryDTo;
import com.example.blog.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/category")
    public String category(){
        return "createCategory";
    }
    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute CategoryDTo categoryDTo){
        categoryService.add(categoryDTo);
        return "redirect:/user/alert";
    }
}
