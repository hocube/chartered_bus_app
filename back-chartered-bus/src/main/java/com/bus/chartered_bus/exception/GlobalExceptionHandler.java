package com.bus.chartered_bus.exception;

import com.bus.chartered_bus.common.model.CommonResponseVO;
import com.bus.chartered_bus.common.model.ExceptionCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


//@RestController
//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResponseVO handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
        return new CommonResponseVO(ExceptionCode.NOT_FOUND.getCode(), e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponseVO handleGlobalException(Exception e, HttpServletRequest request) {
        return new CommonResponseVO(ExceptionCode.INTERNAL_SERVER_ERROR.getCode(), "서버 오류가 발생했습니다: " + e.getMessage(), request.getRequestURI());
    }
}
