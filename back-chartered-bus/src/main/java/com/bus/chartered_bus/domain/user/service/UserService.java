package com.bus.chartered_bus.domain.user.service;


import com.bus.chartered_bus.domain.user.model.UserVO;
import com.bus.chartered_bus.domain.user.repository.UserRepository;
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
        List<UserVO> userList = userRepository.selectAll();
        // 콘솔에 출력
        userList.forEach(user -> System.out.println("Service - Email: " + user.getEmail() + ", Name: " + user.getName()));
        return userList;
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
