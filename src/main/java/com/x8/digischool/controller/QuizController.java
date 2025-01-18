package com.x8.digischool.controller;

import com.x8.digischool.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    // 퀴즈 전체 목록 조회
    @GetMapping("/api/quizzes")
    public ResponseEntity<?> searchQuizzes(){
        return ResponseEntity.ok().body(quizService.searchQuizzes());
    }
}
