package com.bus.chartered_bus.Mapper;

import com.bus.chartered_bus.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonMapper {
    @Select("SELECT * FROM YW_USER")
    List<User> selectAllUsers();
}
