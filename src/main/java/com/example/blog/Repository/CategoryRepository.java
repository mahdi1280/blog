package com.example.blog.Repository;

import com.example.blog.model.entity.Category;
import com.example.blog.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
