package com.x8.digischool.repository;

import com.x8.digischool.domain.Quiz;
import com.x8.digischool.domain.QuizOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizOptionRepository extends JpaRepository<QuizOption, Long> {
    List<QuizOption> findByQuiz(Quiz quiz);
    List<QuizOption> findByQuizId(Long quizId);
}
