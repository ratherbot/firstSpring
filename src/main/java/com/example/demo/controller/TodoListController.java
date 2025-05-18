package com.example.demo.controller;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.service.TodoListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolists")
public class TodoListController {
    private final TodoListService service;

    public TodoListController(TodoListService service) {
        this.service = service;
    }

    @PostMapping
    public TodoListDTO createTodoList(@RequestBody TodoListDTO dto) {
        return service.createTodoList(dto);
    }

    @GetMapping
    public List<TodoListDTO> getAllTodoLists() {
        return service.getAllTodoLists();
    }
}