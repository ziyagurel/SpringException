package com.ziyagurel.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    ArticleService service;

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id){
        return this.service.getUserById(id);
    }
}
