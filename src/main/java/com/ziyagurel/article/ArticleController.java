package com.ziyagurel.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ArticleController {

    @Autowired
    ArticleService service;

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id){
        return this.service.getUserById(id);
    }

    @PostMapping("/articles")
    public Article save(@Valid @RequestBody Article article){
        return this.service.save(article);
    }
}
