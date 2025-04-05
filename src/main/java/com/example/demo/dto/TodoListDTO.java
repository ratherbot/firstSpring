package com.example.demo.dto;

import java.util.List;

public class TodoListDTO {
    private String name;
    private List<String> events;

    public TodoListDTO() {}

    public TodoListDTO(String name, List<String> events) {
        this.name = name;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }
}