package com.example.tech1test.service;

import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import java.util.List;

public interface ArticleService {
    Article save(Article article);

    List<Article> findAll();

    List<Article> findAllByColorAndUser(Article.Color color, User user);
}
