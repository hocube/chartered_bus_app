package com.bus.chartered_bus.exception;

import com.bus.chartered_bus.common.model.CommonResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResponseVO handleIllegalArgumentException(IllegalArgumentException e){
        return new CommonResponseVO("NOT_FOUND", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponseVO handleGlobalException(Exception e) {
        return new CommonResponseVO("INTERNAL_SERVER_ERROR", "서버 오류가 발생했습니다.");
    }
}
