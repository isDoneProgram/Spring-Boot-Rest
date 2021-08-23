package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT * FROM TODO", BeanPropertyRowMapper.newInstance(Todo.class));
    }

    @Override
    public Todo findByTodo(String task) {
        return jdbcTemplate.queryForObject("SELECT * FROM TODO WHERE TASK=?", BeanPropertyRowMapper.newInstance(Todo.class), task);
    }

    @Override
    public int deleteByTodo(String task) {
        return jdbcTemplate.update("DELETE FROM TODO WHERE TASK=?", task);
    }

    @Override
    public int insertByTodo(Todo todo) {
        return jdbcTemplate.update("INSERT INTO TODO VALUES(?,?)", todo.getTask(), todo.isCompleted());
    }

    @Override
    public int updateByTodo(Todo todo) {
        return jdbcTemplate.update("UPDATE TODO SET COMPLETED = ? WHERE TASK = ?", todo.isCompleted(), todo.getTask());
    }
}
