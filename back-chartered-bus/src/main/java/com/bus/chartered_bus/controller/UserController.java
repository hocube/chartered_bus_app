package com.bus.chartered_bus.controller;

import com.bus.chartered_bus.Model.User;
import com.bus.chartered_bus.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = userService.getAllUser();
        users.forEach(user -> System.out.println(user));
        return users;
    }
}
