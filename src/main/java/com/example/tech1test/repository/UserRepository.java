package com.example.tech1test.repository;

import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select distinct u.name from User u join Article a on a.user = u "
            + "group by u having count(a.id) > 3")
    List<String> findUniqueNamesByArticlesCount();

    List<User> findAllByAgeIsGreaterThan(Integer age);

    @Query("select distinct u from User u join Article a on a.user = u where a.color = :color")
    List<User> findAllByArticleColor(Article.Color color);

    Optional<User> findById(Long id);
}
