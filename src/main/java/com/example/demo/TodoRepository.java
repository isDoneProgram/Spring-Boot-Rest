package com.example.demo;

import java.util.List;

interface TodoRepository {
    List<Todo> findAll();

    Todo findByTodo(String task);

    int deleteByTodo(String task);

    int insertByTodo(Todo todo);

    int updateByTodo(Todo todo);
}
