package com.example.tech1test.service;

import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final ArticleService articleService;

    public DataInitializer(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @PostConstruct
    public void inject() {
        User user = new User();
        user.setAge(18);
        user.setName("Bob");
        userService.save(user);

        User alex = new User();
        alex.setName("Alex");
        alex.setAge(20);
        userService.save(alex);

        User alice = new User();
        alice.setName("Alice");
        alice.setAge(25);
        userService.save(alice);

        Article article = new Article();
        article.setColor(Article.Color.BLACK);
        article.setUser(alex);
        article.setText("Test 1");
        articleService.save(article);

        Article article1 = new Article();
        article1.setColor(Article.Color.GREEN);
        article1.setUser(alex);
        article1.setText("Test 1");
        articleService.save(article1);

        Article article2 = new Article();
        article2.setColor(Article.Color.BLACK);
        article2.setUser(alex);
        article2.setText("Test 1");
        articleService.save(article2);

        Article article3 = new Article();
        article3.setColor(Article.Color.RED);
        article3.setUser(alex);
        article2.setText("Test 1");
        articleService.save(article3);

        Article article4 = new Article();
        article4.setText("Test 2");
        article4.setColor(Article.Color.BLUE);
        article4.setUser(alice);
        articleService.save(article4);

        Article article5 = new Article();
        article5.setUser(alice);
        article5.setColor(Article.Color.BLACK);
        article5.setText("Test 2");
        articleService.save(article5);

        Article article6 = new Article();
        article6.setText("Test 2");
        article6.setColor(Article.Color.BLUE);
        article6.setUser(alice);
        articleService.save(article6);

        Article article7 = new Article();
        article7.setUser(alice);
        article7.setColor(Article.Color.BLACK);
        article7.setText("Test 2");
        articleService.save(article7);
    }
}
