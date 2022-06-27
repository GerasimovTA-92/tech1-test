package com.example.tech1test.service.mapper;

import com.example.tech1test.dto.request.UserRequestDto;
import com.example.tech1test.dto.response.UserResponseDto;
import com.example.tech1test.dto.response.UserWithArticleResponseDto;
import com.example.tech1test.model.Article;
import com.example.tech1test.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper implements ResponseDtoMapper<UserResponseDto, User>,
        BiResponseDtoMapper<UserWithArticleResponseDto, User, List<Article>>,
        RequestDtoMapper<User, UserRequestDto> {
    private final ArticleDtoMapper articleDtoMapper;

    public UserDtoMapper(ArticleDtoMapper articleDtoMapper) {
        this.articleDtoMapper = articleDtoMapper;
    }

    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }

    @Override
    public UserWithArticleResponseDto toDto(User user, List<Article> articles) {
        UserWithArticleResponseDto userWithArticleResponseDto = new UserWithArticleResponseDto();
        userWithArticleResponseDto.setArticles(articles.stream()
                .map(articleDtoMapper::toDto)
                .collect(Collectors.toList()));
        userWithArticleResponseDto.setId(user.getId());
        userWithArticleResponseDto.setAge(user.getAge());
        userWithArticleResponseDto.setName(user.getName());
        return userWithArticleResponseDto;
    }

    @Override
    public User toModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setAge(userRequestDto.getAge());
        user.setName(userRequestDto.getName());
        return user;
    }
}
