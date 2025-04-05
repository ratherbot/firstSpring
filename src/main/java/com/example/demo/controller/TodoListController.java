package com.example.demo.controller;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolists")
public class TodoListController {

    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListController(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @PostMapping
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoListDTO todoListDTO) {
        TodoList todoList = new TodoList(todoListDTO.getName(), todoListDTO.getEvents());
        TodoList savedTodoList = todoListRepository.save(todoList);
        return ResponseEntity.ok(savedTodoList);
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> getAllTodoLists() {
        List<TodoList> todoLists = todoListRepository.findAll();
        return ResponseEntity.ok(todoLists);
    }
}