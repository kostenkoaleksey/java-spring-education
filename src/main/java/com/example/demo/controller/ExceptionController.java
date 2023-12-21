package com.example.demo.controller;

import com.example.demo.exception.ExceptionResponse;
import com.example.demo.exception.FacultyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(FacultyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleEntityNotFoundException(FacultyNotFoundException e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
