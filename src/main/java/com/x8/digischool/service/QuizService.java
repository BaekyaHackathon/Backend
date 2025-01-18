package com.x8.digischool.service;

import com.x8.digischool.domain.Quiz;
import com.x8.digischool.domain.QuizOption;
import com.x8.digischool.dto.QuizDto;
import com.x8.digischool.dto.QuizOptionDto;
import com.x8.digischool.repository.QuizOptionRepository;
import com.x8.digischool.repository.QuizRepository;
import com.x8.digischool.dto.ApiResponseDto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizOptionRepository quizOptionRepository;

    /**
     * 퀴즈 전체 목록 조회
     * @return status, quizDto(퀴즈 목록)
     */
    public ResponseDto searchQuizzes() {
        List<Quiz> quizList = quizRepository.findAll();

        List<QuizDto.QuizInfoDto> quizDto = new ArrayList<>();
        for (Quiz quiz : quizList) {
            List<QuizOption> quizOptions = quizOptionRepository.findByQuiz(quiz);

            // Option 데이터를 quiz_id로 조회
            List<QuizOptionDto.QuizOptionInfoDto> optionDtoList = quizOptions.stream()
                    .map(option -> new QuizOptionDto.QuizOptionInfoDto(option.getId(), option.getOption_text(), option.getIs_correct()))
                    .collect(Collectors.toList());

            quizDto.add(QuizDto.QuizInfoDto.builder()
                    .quiz_id(quiz.getId())
                    .question_text(quiz.getQuestion_text())
                    .lesson_id(quiz.getLesson().getId())
                    .options(optionDtoList)
                    .build());
        }
        return new ResponseDto("success", quizDto);
    }

}