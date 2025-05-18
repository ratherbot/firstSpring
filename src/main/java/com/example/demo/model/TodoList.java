package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "todo_lists")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "todo_events", joinColumns = @JoinColumn(name = "todo_list_id"))
    @Column(name = "event")
    private List<String> events;

    public TodoList(String name, List<String> events) {
        this.name = name;
        this.events = events;
    }
}