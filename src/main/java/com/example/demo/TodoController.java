package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
record TodoController(TodoRepository todoRepository) {
    @GetMapping("/all")
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping("/insert")
    public int insertTodo(@RequestBody Todo todo) {
        return todoRepository.insertByTodo(todo);
    }

    @DeleteMapping("/delete/{task}")
    public int deleteTodo(@PathVariable("task") String task) {
        return todoRepository.deleteByTodo(task);
    }

    @GetMapping("/{task}")
    public Todo selectTodo(@PathVariable("task") String task) {
        return todoRepository.findByTodo(task);
    }

    @PutMapping
    public int updateTodo(@RequestBody Todo todo) {
        return todoRepository.updateByTodo(todo);
    }
}
