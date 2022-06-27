package com.example.tech1test.service.impl;

import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import com.example.tech1test.repository.ArticleRepository;
import com.example.tech1test.service.ArticleService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findAllByColorAndUser(Article.Color color, User user) {
        return articleRepository.findAllByColorAndUser(color, user);
    }
}
