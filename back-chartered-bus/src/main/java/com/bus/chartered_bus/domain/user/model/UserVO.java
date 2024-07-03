package com.bus.chartered_bus.domain.user.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserVO {

    private String Email;
    private String Name;

    //@NotNull(message = "ID에 Null 값을 넣을 수 없습니다.")
    //@NotBlank
}

