package com.ziyagurel.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomAdviceError {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorPage handleNoSuchElementException(NotFoundException exception, HttpServletRequest request){
        return new ErrorPage(404,exception.getMessage(),request.getServletPath());
    }
}
