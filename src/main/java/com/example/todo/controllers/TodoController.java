package com.example.todo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dtos.TodoDTO;
import com.example.todo.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping()
    public List<TodoDTO> getAll() {
        return todoService.findAll();
    }  
    
    @GetMapping(value="/completed")
    public List<TodoDTO> getAllCompleted() {
        return todoService.findAllCompleted();
    }
    
    @GetMapping(value="/pending")
    public List<TodoDTO> getAllPending() {
        return todoService.findAllPending();
    } 
    
    @PutMapping(value="/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable("id") Long id, @RequestBody TodoDTO todo) {
    	if (todoService.findById(id) == null)
    		return new ResponseEntity<TodoDTO>(HttpStatus.NOT_FOUND);
    	
    	TodoDTO todo1 = todoService.save(todo);
    	return new ResponseEntity<TodoDTO>(todo1, HttpStatus.CREATED); 
	}
    
    @PostMapping()
    public ResponseEntity<TodoDTO> create(@RequestBody TodoDTO todo) {
		return new ResponseEntity<TodoDTO>(todoService.save(todo), HttpStatus.CREATED); 
	}
    
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") Long id) {
    	todoService.delete(id);
	}
}
