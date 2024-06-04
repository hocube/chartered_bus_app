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


    // 사용자 조회
    public List<UserVO> selectAll() {
        return sqlSessionTemplate.selectList(NAME_SPACE + "selectAll");
//                                                      ||
//      return sqlSessionTemplate.selectList("UserMapper.selectAll");
    }

    // 사용자 등록
    public int createUser(UserVO userVO) {
        return sqlSessionTemplate.insert(NAME_SPACE + "insertUser", userVO);
    }

    // 사용자 삭제
    public int deleteUser(String userId) {
        return sqlSessionTemplate.delete(NAME_SPACE + "deleteUser", userId);
    }
}
