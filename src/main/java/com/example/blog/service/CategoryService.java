package com.example.blog.service;

import com.example.blog.Repository.CategoryRepository;
import com.example.blog.model.dto.CategoryDTo;
import com.example.blog.model.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category add(CategoryDTo categoryDTo){
        Category category = new Category();
        category.setTitle(categoryDTo.getCategory());
        return categoryRepository.save(category);

    }

    public List<Category> findAll(){

        return categoryRepository.findAll();
    }
}
