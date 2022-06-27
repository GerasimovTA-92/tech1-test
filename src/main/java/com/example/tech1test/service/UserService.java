package com.example.tech1test.service;

import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    List<String> findByArticleMoreThan();

    List<User> findAllByAgeGreaterThan(Integer age);

    List<User> findAllByArticleColor(Article.Color color);

    User findById(Long id);
}
