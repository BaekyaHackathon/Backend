package com.x8.digischool.domain;

public class ReviewLessonDTO {
    //Lesson의 id
    private Long id;
    private String title;
    private String url;
    private Integer progress_rate;

    public ReviewLessonDTO(Long id, String title, String url, Integer progress_rate){
        this.id = id;
        this.title = title;
        this.url = url;
        this.progress_rate = progress_rate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Integer getProgress_rate() {
        return progress_rate;
    }
}
