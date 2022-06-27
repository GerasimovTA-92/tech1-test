package com.example.tech1test.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D toDto(M m);
}
