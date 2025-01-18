package com.x8.digischool.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LessonDetailDto {
    private Long id;
    private String title;
    private String description;
    private String videoUrl;
    private Integer progressRate;
}
