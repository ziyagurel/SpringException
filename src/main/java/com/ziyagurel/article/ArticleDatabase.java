package com.ziyagurel.article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDatabase extends JpaRepository<Article, Long> {

}
