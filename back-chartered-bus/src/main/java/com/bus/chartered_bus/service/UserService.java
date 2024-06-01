package com.bus.chartered_bus.service;

import com.bus.chartered_bus.model.UserVO;
import com.bus.chartered_bus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // User 목록 조회
    public List<UserVO> findAll() {
        return userRepository.selectAll();
    }
}