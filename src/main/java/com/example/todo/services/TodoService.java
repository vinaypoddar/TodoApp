package com.example.todo.services;

import java.util.List;

import com.example.todo.dtos.TodoDTO;

public interface TodoService {

	List<TodoDTO> findAll();

	List<TodoDTO> findAllPending();

	List<TodoDTO> findAllCompleted();

	TodoDTO save(TodoDTO todo);

	void delete(Long id);

	Object findById(Long id);
	
	

}
