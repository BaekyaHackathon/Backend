package com.x8.digischool.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgressSaveDto {
    private Long userId;
    private Long lessonId;
    private Integer progressRate;
}