package com.x8.digischool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ApiResponseDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDto<T> {
        private String status;   // 메시지
        private T data;       // 추가 데이터 (선택적)
    }
}
