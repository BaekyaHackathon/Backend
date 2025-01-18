package com.x8.digischool.repository;


import com.x8.digischool.domain.WrongQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WrongQuizRepository extends JpaRepository<WrongQuiz, Long> {
    List<WrongQuiz> findByUserId(Long id);

}
