package com.bus.chartered_bus.domain.user.controller;


import com.bus.chartered_bus.domain.user.model.UserVO;
import com.bus.chartered_bus.domain.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        result.forEach(user-> System.out.println("Controller - Email: " + user.getEmail() + ", Name: " + user.getName()));
        return result;
    }

    // User 입력
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserVO userVO) {
        String resultMessage = userService.createUser(userVO);
        if ("사용자 등록 성공".equals(resultMessage)){
            return new ResponseEntity<>(resultMessage, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(resultMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        String resultMessage = userService.deleteUser(userId);
        if("사용자 삭제 성공".equals(resultMessage)){
            return new ResponseEntity<>(resultMessage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultMessage, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
