package com.example.tech1test.service.mapper;

public interface BiResponseDtoMapper<D, M, T> {
    D toDto(M m, T t);
}
