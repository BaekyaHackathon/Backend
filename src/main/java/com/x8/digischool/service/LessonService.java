package com.x8.digischool.service;

import com.x8.digischool.domain.Lesson;
import com.x8.digischool.domain.Progress;
import com.x8.digischool.domain.dto.LessonDetailDto;
import com.x8.digischool.domain.dto.LessonDto;
import com.x8.digischool.repository.LessonRepository;
import com.x8.digischool.repository.ProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LessonService {

    private final LessonRepository lessonRepository;
    private final ProgressRepository progressRepository;

    public List<LessonDto> getAllLessons() {
        // LessonRepository를 사용하여 모든 Lesson 조회
        List<Lesson> lessons = lessonRepository.findAll();

        // Lesson 데이터를 LessonDto로 변환
        return lessons.stream()
                .map(lesson -> new LessonDto(
                        lesson.getId(),
                        lesson.getTitle(),
                        lesson.getThumbnailUrl(),
                        null // ProgressRate는 모든 Lesson 조회에선 불필요하므로 null로 처리
                ))
                .collect(Collectors.toList());
    }

    public LessonDetailDto getLessonDetail(Long lessonId, Long userId) {
        // 강의 조회
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new IllegalArgumentException("Lesson not found"));

        // 진행률 조회 (사용자는 1로 고정)
        Progress progress = progressRepository.findByUserIdAndLessonId(userId, lessonId)
                .orElseThrow(() -> new IllegalArgumentException("Progress not found"));

        // DTO 생성 및 반환
        return new LessonDetailDto(
                lesson.getId(),
                lesson.getTitle(),
                lesson.getDescription(),
                lesson.getVideoUrl(),
                progress.getProgressRate()
        );
    }
}
