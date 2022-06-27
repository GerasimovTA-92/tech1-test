package com.example.tech1test.dto.response;

import com.example.tech1test.model.Article;

public class ArticleResponseDto {
    private Long id;
    private String text;
    private Article.Color color;

    public ArticleResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Article.Color getColor() {
        return color;
    }

    public void setColor(Article.Color color) {
        this.color = color;
    }
}
