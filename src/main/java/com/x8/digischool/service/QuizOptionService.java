package com.x8.digischool.service;

import com.x8.digischool.domain.QuizOption;
import com.x8.digischool.repository.QuizOptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizOptionService {
    @Autowired
    private QuizOptionsRepository quizOptionsRepository;

    public List<QuizOption> getOptionsByQuizId(Long quizId){
        return quizOptionsRepository.findByQuizId(quizId);
    }

}
