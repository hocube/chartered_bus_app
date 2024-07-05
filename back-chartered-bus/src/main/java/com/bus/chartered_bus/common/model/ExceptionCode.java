package com.bus.chartered_bus.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "서버 내부 오류가 발생했습니다."),
    NOT_FOUND("NOT_FOUND", "요청한 리소스를 찾을 수 없습니다."),
    BAD_REQUEST("BAD_REQUEST", "잘못된 요청입니다."),
    UNAUTHORIZED("UNAUTHORIZED", "인증되지 않은 사용자입니다."),
    FORBIDDEN("FORBIDDEN", "접근이 금지되었습니다."),
    METHOD_NOT_ALLOWED("METHOD_NOT_ALLOWED", "허용되지 않는 메소드입니다."),
    CONFLICT("CONFLICT", "요청이 현재 서버의 상태와 충돌합니다."),
    PAYLOAD_TOO_LARGE("PAYLOAD_TOO_LARGE", "요청 페이로드가 너무 큽니다."),
    UNSUPPORTED_MEDIA_TYPE("UNSUPPORTED_MEDIA_TYPE", "지원하지 않는 미디어 타입입니다."),
    TOO_MANY_REQUESTS("TOO_MANY_REQUESTS", "너무 많은 요청이 발생했습니다."),
    SERVER_ERROR("SERVER_ERROR", "서버 오류가 발생했습니다.");

    private final String code;
    private final String message;
}
