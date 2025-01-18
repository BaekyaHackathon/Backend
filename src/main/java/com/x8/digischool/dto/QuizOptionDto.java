package com.x8.digischool.dto;

import lombok.*;

public class QuizOptionDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class QuizOptionInfoDto {
        private Long option_id;
        private String option_text;
        private Boolean is_correct;
    }
}
