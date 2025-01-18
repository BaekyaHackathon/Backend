package com.x8.digischool.repository;

import com.x8.digischool.domain.QuizOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizOptionsRepository extends JpaRepository<QuizOption, Long> {
    List<QuizOption> findByQuizId(Long quizId);
}
