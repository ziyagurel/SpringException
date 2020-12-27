package com.ziyagurel.article;

import com.ziyagurel.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleDatabase articleDatabase;

    public Article getUserById(Long id) {
        return articleDatabase.findById(id).orElseThrow(() -> new NotFoundException("Article does not found"));
    }
}
