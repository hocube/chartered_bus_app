package com.bus.chartered_bus.repository;

import com.bus.chartered_bus.model.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private static final String NAME_SPACE = "UserMapper.";

    // 생성자 주입 방식
    private final SqlSessionTemplate sqlSessionTemplate;

    public UserRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    // User 조회
    public List<UserVO> selectAll() {

        return sqlSessionTemplate.selectList(NAME_SPACE + "selectAll");
//        return sqlSessionTemplate.selectList("UserMapper.selectAll");
    }
}
