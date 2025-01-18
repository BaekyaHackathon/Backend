package com.x8.digischool.service;

import com.x8.digischool.domain.Lesson;
import com.x8.digischool.domain.Progress;
import com.x8.digischool.domain.dto.ProgressSaveDto;
import com.x8.digischool.repository.LessonRepository;
import com.x8.digischool.repository.ProgressRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressService {

    private final LessonRepository lessonRepository;
    private final ProgressRepository progressRepository;

    public void saveProgress(ProgressSaveDto dto) {
        // lessonId 유효성 검증
        Lesson lesson = lessonRepository.findById(dto.getLessonId())
                .orElseThrow(() -> new IllegalArgumentException("Lesson not found"));

        // 진행률 업데이트 또는 새로 생성
        Optional<Progress> existingProgress = progressRepository.findByUserIdAndLessonId(
                dto.getUserId(), dto.getLessonId());

        Progress progress = existingProgress.orElseGet(() -> {
            Progress newProgress = new Progress();
            newProgress.setUserId(dto.getUserId());
            newProgress.setLesson(lesson);
            return newProgress;
        });

        progress.setProgressRate(dto.getProgressRate());
        progressRepository.save(progress);
    }
}
