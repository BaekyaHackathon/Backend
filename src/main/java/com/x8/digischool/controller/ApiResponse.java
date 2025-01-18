package com.x8.digischool.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ApiResponse(String status) {
        this.status = status;
        this.data = null;
    }
}
