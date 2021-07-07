package com.example.blog.service;

import com.example.blog.Repository.UserRepository;
import com.example.blog.model.dto.UserDTO;
import com.example.blog.model.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Users add(UserDTO userDTO){
        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());
        users.setName(userDTO.getName());
        return userRepository.save(users);
    }
}
