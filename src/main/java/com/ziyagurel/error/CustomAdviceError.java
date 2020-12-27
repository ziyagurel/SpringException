package com.ziyagurel.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomAdviceError {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorPage handleNoSuchElementException(NotFoundException exception, HttpServletRequest request){
        return new ErrorPage(404,exception.getMessage(),request.getServletPath());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorPage handleNotNullException(MethodArgumentNotValidException exception, HttpServletRequest request){
        ErrorPage err = new ErrorPage(400,exception.getMessage(),request.getServletPath());
        BindingResult bindingResult = exception.getBindingResult();
        Map<String,String> validationError = new HashMap<>();
        for(FieldError fieldError : bindingResult.getFieldErrors()){
            validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        err.setValidationError(validationError);
        return err;
    }
}
