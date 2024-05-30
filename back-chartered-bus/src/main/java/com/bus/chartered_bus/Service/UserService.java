package com.bus.chartered_bus.Service;

import com.bus.chartered_bus.Mapper.CommonMapper;
import com.bus.chartered_bus.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final CommonMapper commonMapper;

    public UserService(CommonMapper commonMapper) {
        this.commonMapper = commonMapper;
    }

    public List<User> getAllUser() {
        return commonMapper.selectAllUsers();
    }
}
