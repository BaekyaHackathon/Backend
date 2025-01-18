package com.x8.digischool.service;

import com.x8.digischool.domain.*;
import com.x8.digischool.repository.WrongQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WrongQuizService {
    @Autowired
    WrongQuizRepository wrongQuizRepository;

    @Autowired
    QuizOptionService quizOptionService;

    public List<WrongQuizDTO> wrongQuizRespond(Users user){
        List<WrongQuizDTO> responses = new ArrayList();

        List<WrongQuiz> wrongQuizzes = findAllByUserId(user);

        for(int i = 0; i < wrongQuizzes.size(); i++){
            WrongQuiz wrongQuiz = wrongQuizzes.get(i);
            Quiz quiz = wrongQuiz.getQuiz();
            List<QuizOption> quizOptions= quizOptionService.getOptionsByQuizId(quiz.getId());
            WrongQuizDTO response = new WrongQuizDTO(quiz.getId(), quiz.getLesson().getId(), quiz.getQuestion_text(), quizOptions);
        }

        return responses;
    }

    public List<ReviewLessonDTO> lessonRespond(Users user){
        return new ArrayList();
    }



    public List<WrongQuiz> findAllByUserId(Users user){
        Long id = user.getId();
        return wrongQuizRepository.findByUserId(id);
    }
}
