package com.x8.digischool.controller;

import com.x8.digischool.domain.Lesson;
import com.x8.digischool.domain.Progress;
import com.x8.digischool.domain.dto.LessonDto;
import com.x8.digischool.domain.dto.LessonDetailDto;
import com.x8.digischool.domain.dto.ProgressSaveDto;
import com.x8.digischool.repository.LessonRepository;
import com.x8.digischool.service.LessonService;
import com.x8.digischool.repository.ProgressRepository;
import com.x8.digischool.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final ProgressService progressService;

    @GetMapping("/api/lessons")
    public ApiResponse<List<LessonDto>> getLessons() {
        // 모든 Lesson 데이터를 조회
        List<LessonDto> lessons = lessonService.getAllLessons();
        return new ApiResponse<>("success", lessons);
    }

    @GetMapping("/api/lessons/{id}")
    public ApiResponse<LessonDetailDto> getLessonDetail(@PathVariable("id") Long lessonId) {
        Long userId = 1L;
        LessonDetailDto lessonDetail = lessonService.getLessonDetail(lessonId, userId);
        return new ApiResponse<>("success", lessonDetail);
    }

    @PostMapping("/api/progress")
    public ApiResponse<?> saveProgress(@RequestBody ProgressSaveDto dto) {
        progressService.saveProgress(dto);
        return new ApiResponse<>("success");
    }
}
