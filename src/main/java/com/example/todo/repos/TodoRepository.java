package com.example.todo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	List<Todo> findAllByCompleted(boolean status);

}
