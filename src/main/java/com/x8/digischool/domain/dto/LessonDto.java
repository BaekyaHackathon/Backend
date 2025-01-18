package com.x8.digischool.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LessonDto {
    private Long id;
    private String title;
    private String thumbnailUrl;
    private Integer progressRate;
}
