package com.example.todo;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.todo.models.Todo;
import com.example.todo.repos.TodoRepository;

@Component
public class DatabasePopulator 
{
	@Autowired
    private TodoRepository todoRepository;
	
	@PostConstruct
	void init()
	{
		try {			
			Todo t1 = new Todo(null, "Task 1", false, new Date());
			Todo t2 = new Todo(null, "Task 2", false, new Date());
			Todo t3 = new Todo(null, "Task 3", true, new Date());
			this.todoRepository.saveAll(Arrays.asList(t1,t2,t3));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
