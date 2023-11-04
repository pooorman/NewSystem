package com.example.newsystem01.controller;

import com.example.newsystem01.entity.User;
import com.example.newsystem01.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }


}
