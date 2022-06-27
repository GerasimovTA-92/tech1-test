package com.example.tech1test.dto.request;

import javax.validation.constraints.NotNull;

public class ArticleRequestDto {
    @NotNull
    private String text;
    @NotNull
    private Long userId;
    @NotNull
    private String color;

    public ArticleRequestDto() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
