package com.example.blog.controller;

import com.example.blog.model.dto.UserDTO;
import com.example.blog.model.entity.Users;
import com.example.blog.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "RegisterUser";
    }
    @PostMapping(value = "/add")
    public String add(@ModelAttribute UserDTO userDTO, Model model) throws IOException {
        userService.add(userDTO);
        model.addAttribute("message" , "با موفقيت اطلاعات ذخيره شد");
        return "redirect:/user/alert";
    }
    @GetMapping("/alert")
    public String alert( Model model){
        model.addAttribute("message" , "با موفقيت اطلاعات ذخيره شد");
        return "alert";
    }
    @GetMapping("/show")
    public String show(Pageable pageable, Model model){
       model.addAttribute("users" ,userService.show(pageable));
       return "showUser";
    }
}
