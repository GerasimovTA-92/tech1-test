package com.example.tech1test.repository;

import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByColorAndUser(Article.Color color, User user);
}
