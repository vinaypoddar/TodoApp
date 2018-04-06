package com.example.todo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dtos.TodoDTO;
import com.example.todo.models.Todo;
import com.example.todo.repos.TodoRepository;

@Service
public class DefaultTodoService implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<TodoDTO> findAll() {
		 List<Todo> todos = this.todoRepository.findAll();
		 List<TodoDTO> todoDtos = todos.stream()
		 	.map(
				 todo -> 
				 	new TodoDTO(todo.getId(), 
				 				todo.getDescription(), 
				 				todo.isCompleted(), 
				 				todo.getCreatedOn()))
		 	.collect(Collectors.toList());
		 return todoDtos;
	}
	
	@Override
	public List<TodoDTO> findAllCompleted() {
		 List<Todo> todos = this.todoRepository.findAllByCompleted(true);
		 List<TodoDTO> todoDtos = todos.stream()
		 	.map(
				 todo -> 
				 	new TodoDTO(todo.getId(), 
				 				todo.getDescription(), 
				 				todo.isCompleted(), 
				 				todo.getCreatedOn()))
		 	.collect(Collectors.toList());
		 return todoDtos;
	}
	
	@Override
	public List<TodoDTO> findAllPending() {
		 List<Todo> todos = this.todoRepository.findAllByCompleted(false);
		 List<TodoDTO> todoDtos = todos.stream()
		 	.map(
				 todo -> 
				 	new TodoDTO(todo.getId(), 
				 				todo.getDescription(), 
				 				todo.isCompleted(), 
				 				todo.getCreatedOn()))
		 	.collect(Collectors.toList());
		 return todoDtos;
	}
	
	@Override
	public TodoDTO save(TodoDTO todo) {
		
		Todo todo1 = this.todoRepository.save(
				new Todo(todo.getId(), todo.getDescription(), todo.isCompleted(), todo.getCreatedOn()));
		
		return new TodoDTO(
				todo1.getId(), todo1.getDescription(), todo1.isCompleted(), todo1.getCreatedOn());
	}

	@Override
	public void delete(Long id) {
		this.todoRepository.deleteById(id);
	}

	@Override
	public TodoDTO findById(Long id) {
		Optional<Todo> todoResult = this.todoRepository.findById(id);
		if(todoResult.isPresent()) {
			Todo todo = todoResult.get();
			return new TodoDTO(todo.getId(), todo.getDescription(), 
					todo.isCompleted(), todo.getCreatedOn());
		} else {
			return null;
		}
		
	}

}
