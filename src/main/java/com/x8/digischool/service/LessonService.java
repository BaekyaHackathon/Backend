package com.x8.digischool.service;

import com.x8.digischool.domain.Progress;
import com.x8.digischool.domain.LessonDto;
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

    private final ProgressRepository progressRepository;

    public List<LessonDto> getLessonsByUser(Long userId) {
        List<Progress> progressList = progressRepository.findByUserId(userId);

        return progressList.stream()
                .map(progress -> new LessonDto(
                        progress.getLesson().getId(),
                        progress.getLesson().getTitle(),
                        progress.getLesson().getThumbnailUrl(),
                        progress.getProgressRate()
                ))
                .collect(Collectors.toList());
    }
}
