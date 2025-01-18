package com.x8.digischool.controller;

import com.x8.digischool.domain.LessonDto;
import com.x8.digischool.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/api/lessons")
    public ApiResponse<List<LessonDto>> getLessons() {
        // User ID is fixed as 1
        Long userId = 1L;
        List<LessonDto> lessons = lessonService.getLessonsByUser(userId);
        return new ApiResponse<>("success", lessons);
    }
}
