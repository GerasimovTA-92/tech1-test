package com.example.tech1test.service.mapper;

public interface RequestDtoMapper<M, D> {
    M toModel(D d);
}
