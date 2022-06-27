package com.example.tech1test.service.mapper;

import com.example.tech1test.dto.request.ArticleRequestDto;
import com.example.tech1test.dto.response.ArticleResponseDto;
import com.example.tech1test.model.Article;
import com.example.tech1test.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ArticleDtoMapper implements ResponseDtoMapper<ArticleResponseDto, Article>,
            RequestDtoMapper<Article, ArticleRequestDto> {
    private final UserService userService;

    public ArticleDtoMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ArticleResponseDto toDto(Article article) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
        articleResponseDto.setId(article.getId());
        articleResponseDto.setColor(article.getColor());
        articleResponseDto.setText(article.getText());
        return articleResponseDto;
    }

    @Override
    public Article toModel(ArticleRequestDto articleRequestDto) {
        Article article = new Article();
        article.setText(articleRequestDto.getText());
        article.setUser(userService.findById(articleRequestDto.getUserId()));
        article.setColor(Article.Color.valueOf(articleRequestDto.getColor().toUpperCase()));
        return article;
    }
}
