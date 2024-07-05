package com.bus.chartered_bus.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResponseVO {
    private String code;
    private String message;
    private String path;
}
