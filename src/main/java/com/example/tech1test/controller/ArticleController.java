package com.example.tech1test.controller;

import com.example.tech1test.dto.request.ArticleRequestDto;
import com.example.tech1test.dto.response.ArticleResponseDto;
import com.example.tech1test.model.Article;
import com.example.tech1test.service.ArticleService;
import com.example.tech1test.service.mapper.RequestDtoMapper;
import com.example.tech1test.service.mapper.ResponseDtoMapper;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final ResponseDtoMapper<ArticleResponseDto, Article> responseDtoMapper;
    private final RequestDtoMapper<Article, ArticleRequestDto> requestDtoMapper;

    public ArticleController(ArticleService articleService, ResponseDtoMapper<ArticleResponseDto,
                            Article> responseDtoMapper,
                             RequestDtoMapper<Article, ArticleRequestDto> requestDtoMapper) {
        this.articleService = articleService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    public ArticleResponseDto add(@RequestBody @Valid ArticleRequestDto articleRequestDto) {
        Article article = requestDtoMapper.toModel(articleRequestDto);
        articleService.save(article);
        return responseDtoMapper.toDto(article);
    }
}
