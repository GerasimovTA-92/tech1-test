package com.example.tech1test.controller;

import com.example.tech1test.dto.request.UserRequestDto;
import com.example.tech1test.dto.response.UserResponseDto;
import com.example.tech1test.dto.response.UserWithArticleResponseDto;
import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import com.example.tech1test.service.ArticleService;
import com.example.tech1test.service.UserService;
import com.example.tech1test.service.mapper.BiResponseDtoMapper;
import com.example.tech1test.service.mapper.RequestDtoMapper;
import com.example.tech1test.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ArticleService articleService;
    private final BiResponseDtoMapper<UserWithArticleResponseDto,
            User, List<Article>> biResponseDtoMapper;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;
    private final RequestDtoMapper<User, UserRequestDto> requestDtoMapper;

    public UserController(UserService userService,
                          ArticleService articleService,
                          BiResponseDtoMapper<UserWithArticleResponseDto,
                                  User, List<Article>> dtoMapper,
                          ResponseDtoMapper<UserResponseDto, User> responseDtoMapper,
                          RequestDtoMapper<User, UserRequestDto> requestDtoMapper) {
        this.userService = userService;
        this.articleService = articleService;
        this.biResponseDtoMapper = dtoMapper;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @GetMapping("/by-articles")
    public List<String> findByArticles() {
        return userService.findByArticleMoreThan();
    }

    @GetMapping("/by-age-greater-than")
    public List<User> findByAge(@RequestParam Integer age) {
        return userService.findAllByAgeGreaterThan(age);
    }

    @GetMapping("/by-color")
    public List<UserWithArticleResponseDto> getAll(@RequestParam String color) {
        System.out.println(userService.findAllByArticleColor(
                Article.Color.valueOf(color.toUpperCase())));
        return userService.findAllByArticleColor(
                Article.Color.valueOf(color.toUpperCase())).stream()
                .map(e -> biResponseDtoMapper.toDto(e,
                        articleService.findAllByColorAndUser(
                                Article.Color.valueOf(color.toUpperCase()), e)))
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponseDto add(@RequestBody @Valid UserRequestDto requestDto) {
        User user = requestDtoMapper.toModel(requestDto);
        userService.save(user);
        return responseDtoMapper.toDto(user);
    }
}
