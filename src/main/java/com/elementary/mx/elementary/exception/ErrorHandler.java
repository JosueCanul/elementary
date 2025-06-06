package com.elementary.mx.elementary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
@SuppressWarnings("")
public class ErrorHandler {

     
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleErrorEntityNotFound(){
    }

    @ExceptionHandler(IncompatibleGradeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleErrorIncompatibleGrade(){
    }

    @ExceptionHandler(DuplicatedScoreRecordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleErrorDuplicatedError(){
    }
}
