package com.example.tech1test.service.impl;

import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import com.example.tech1test.repository.UserRepository;
import com.example.tech1test.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<String> findByArticleMoreThan() {
        return userRepository.findUniqueNamesByArticlesCount();
    }

    @Override
    public List<User> findAllByAgeGreaterThan(Integer age) {
        return userRepository.findAllByAgeIsGreaterThan(age);
    }

    @Override
    public List<User> findAllByArticleColor(Article.Color color) {
        return userRepository.findAllByArticleColor(color);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
