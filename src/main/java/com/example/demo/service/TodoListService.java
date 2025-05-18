package com.example.demo.service;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoListService {
    private final TodoListRepository repository;

    public TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }

    public TodoListDTO createTodoList(TodoListDTO dto) {
        TodoList entity = new TodoList(dto.name(), dto.events());
        TodoList saved = repository.save(entity);
        return new TodoListDTO(saved.getName(), saved.getEvents());
    }

    public List<TodoListDTO> getAllTodoLists() {
        return repository.findAll().stream()
                .map(e -> new TodoListDTO(e.getName(), e.getEvents()))
                .collect(Collectors.toList());
    }
}