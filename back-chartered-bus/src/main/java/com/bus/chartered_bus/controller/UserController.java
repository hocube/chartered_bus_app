package com.bus.chartered_bus.controller;

import com.bus.chartered_bus.model.UserVO;
import com.bus.chartered_bus.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // User 조희
    @GetMapping
    public List<UserVO> selectAll(){
        List<UserVO> result = userService.findAll();
        result.forEach(user-> System.out.println(user));
        return result;
    }
}
