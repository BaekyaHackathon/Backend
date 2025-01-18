package com.x8.digischool.dto;

import lombok.*;

import java.util.List;

public class QuizDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class QuizInfoDto {
        private Long quiz_id;
        private String question_text;
        private Long lesson_id;
        private List<QuizOptionDto.QuizOptionInfoDto> options;
    }
}
