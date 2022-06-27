package com.example.tech1test.repository;

import com.example.tech1test.Tech1TestApplication;
import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void findAllUsersByAgeGreaterThan_Ok() {
        User alex = new User();
        alex.setName("Alex");
        alex.setAge(20);
        alex.setId(2L);

        User alice = new User();
        alice.setName("Alice");
        alice.setAge(25);
        alice.setId(3L);
        List<User> expected = List.of(alex, alice);
        List<User> actual = userRepository.findAllByAgeIsGreaterThan(18);
        assertEquals(expected, actual);
    }

    @Test
    public void findAllByArticleColor_Ok() {
        User alex = new User();
        alex.setName("Alex");
        alex.setAge(20);
        alex.setId(2L);

        User alice = new User();
        alice.setName("Alice");
        alice.setAge(25);
        alice.setId(3L);
        List<User> expected = List.of(alex, alice);
        List<User> actual = userRepository.findAllByArticleColor(Article.Color.BLACK);
        assertEquals(expected, actual);
    }

    @Test
    public void findById_Ok() {
        User alex = new User();
        alex.setName("Alex");
        alex.setAge(20);
        alex.setId(2L);

        Optional<User> expected = Optional.of(alex);
        Optional<User> actual = userRepository.findById(2L);
        assertEquals(expected, actual);
    }

    @Test
    public void findById_NotOk() {
        assertEquals(Optional.empty(), userRepository.findById((long) (userRepository.findAll().size() + 1)));
    }

    @Test
    public void findAllByArticlesCount() {
        List<String> expected = List.of("Alex", "Alice");
        List<String> actual = userRepository.findUniqueNamesByArticlesCount();
        assertEquals(expected, actual);
    }
}