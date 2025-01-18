package com.x8.digischool.domain;

import java.util.List;

public class WrongQuizDTO {
    private long quiz_id;
    private long lesson_id;
    private String question_text;
    private List<QuizOption> options;

    public WrongQuizDTO(Long quiz_id, long lesson_id, String question_text, List<QuizOption> options){
        this.quiz_id = quiz_id;
        this.lesson_id = lesson_id;
        this.question_text = question_text;
        this.options = options;
    }

    public long getQuiz_id() {
        return quiz_id;
    }

    public long getLesson_id() {
        return lesson_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public List<QuizOption> getOptions() {
        return options;
    }
}
