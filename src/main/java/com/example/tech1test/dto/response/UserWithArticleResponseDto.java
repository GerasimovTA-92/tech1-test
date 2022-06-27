package com.example.tech1test.dto.response;

import java.util.List;

public class UserWithArticleResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private List<ArticleResponseDto> articles;

    public UserWithArticleResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<ArticleResponseDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleResponseDto> articles) {
        this.articles = articles;
    }
}
