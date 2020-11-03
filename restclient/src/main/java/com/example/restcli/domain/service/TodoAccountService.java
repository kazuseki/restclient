package com.example.restcli.domain.service;

import com.example.restcli.domain.model.Todo;

public interface TodoAccountService {

    String findAll();

    Todo findOne(String todoId);

    String findByTodoTitle(String todoTitle);

//    Todo create(Todo todo);
//
//    Todo finish(String todoId);
//
//    void delete(String todoId);
}