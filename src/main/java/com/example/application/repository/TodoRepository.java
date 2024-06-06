package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
