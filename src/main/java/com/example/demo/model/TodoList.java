package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "todo_lists")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "todo_events", joinColumns = @JoinColumn(name = "todo_list_id"))
    @Column(name = "event")
    private List<String> events;

    public TodoList() {}

    public TodoList(String name, List<String> events) {
        this.name = name;
        this.events = events;
    }

    public Long getId() {
        return id;
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