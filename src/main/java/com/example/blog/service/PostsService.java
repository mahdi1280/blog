package com.example.blog.service;

import com.example.blog.Repository.CategoryRepository;
import com.example.blog.Repository.PostsRepository;
import com.example.blog.Repository.UserRepository;
import com.example.blog.model.dto.PostsDTO;
import com.example.blog.model.entity.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public PostsService(PostsRepository postsRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.postsRepository = postsRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public Posts add(PostsDTO postsDTO, String name) throws IOException {
        Posts posts = new Posts();
        posts.setBody(postsDTO.getBody());

        posts.getCategories().add(categoryRepository.findByTitle(postsDTO.getCategory()));

        posts.setTitle(postsDTO.getTitle());
        posts.setUsers(userRepository.findByEmail(name));
        String path = ResourceUtils.getFile("classpath:static/image").getAbsolutePath();
        byte[] bytes = postsDTO.getFile().getBytes();
        String name1 = UUID.randomUUID() + "." + Objects.requireNonNull(postsDTO.getFile().getContentType()).split("/")[1];
        Files.write(Paths.get(path + File.separator + name1), bytes);
        posts.setCover(name1);
        return postsRepository.save(posts);
    }

    public Page<Posts> show(Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

}
