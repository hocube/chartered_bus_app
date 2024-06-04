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

    // 사용자 목록 조회
    public List<UserVO> findAll() {
        return userRepository.selectAll();
    }

    // 사용자 등록
    public String createUser(UserVO userVO){
        int result = userRepository.createUser(userVO);
        if(result > 0) {
            return "사용자 등록 성공";
        } else {
            return "사용자 등록 실패";
        }
    }

    // 사용자 삭제
    public String deleteUser(String userId) {
        int result = userRepository.deleteUser(userId);
        if(result > 0) {
            return "사용자 삭제 성공";
        } else {
            return "사용자 삭제 실패";
        }
    }
}
