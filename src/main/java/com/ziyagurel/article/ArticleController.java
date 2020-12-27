package com.ziyagurel.article;

import com.ziyagurel.error.ErrorPage;
import com.ziyagurel.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ArticleController {

    @Autowired
    ArticleService service;

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id){
        return this.service.getUserById(id);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorPage handleNoSuchElementException(NotFoundException exception, HttpServletRequest request){
        return new ErrorPage(404,exception.getMessage(),request.getServletPath());
    }
}
