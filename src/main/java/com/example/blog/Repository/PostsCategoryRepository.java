package com.example.blog.Repository;

import com.example.blog.model.entity.PostsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsCategoryRepository extends JpaRepository<PostsCategory,Integer> {
}
