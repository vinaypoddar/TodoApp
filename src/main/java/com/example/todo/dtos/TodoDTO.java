package com.example.todo.dtos;

import java.io.Serializable;
import java.util.Date;

public class TodoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -485285807357154749L;

private Long id;
	
	private String description;
	
	private boolean completed;
	
	private Date createdOn = new Date();
	
	public TodoDTO() {
		super();
	}

	public TodoDTO(Long id, String description, boolean completed, Date createdOn) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
		this.createdOn = createdOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}
