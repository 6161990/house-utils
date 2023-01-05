package com.yoonji.houseUtils.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_REQUEST("잘못된 요청입니다."),
    INTERVAL_ERROR("알 수 없는 에러가 발생했습니다."),
    ENTITY_NOT_FOUND("데이터를 찾을 수 없습니다.");

    private final String errorMessage;

}
