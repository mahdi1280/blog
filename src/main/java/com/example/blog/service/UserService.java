package com.example.blog.service;

import com.example.blog.Repository.UserRepository;
import com.example.blog.model.dto.UserDTO;
import com.example.blog.model.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public Users add(UserDTO userDTO) throws IOException {
        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        users.setName(userDTO.getName());
        String path = ResourceUtils.getFile("classpath:static/image").getAbsolutePath();
        String name = UUID.randomUUID()+"." + Objects.requireNonNull(userDTO.getFile().getContentType()).split("/")[1];
        byte[] bytes = userDTO.getFile().getBytes();
        Files.write(Paths.get(path + File.separator + name), bytes);
        users.setCover(name);

       users.getRoles().add(userDTO.getRoles());

        return userRepository.save(users);
    }
    public Page<Users> show(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
