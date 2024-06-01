package com.bus.chartered_bus.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserVO {

    private Long keyId;

    @NotNull(message = "ID에 Null 값을 넣을 수 없습니다.")
    private String userId;

    @NotBlank
    private String userName;

    private String userPw;

    private char userSts = 'A';
}

