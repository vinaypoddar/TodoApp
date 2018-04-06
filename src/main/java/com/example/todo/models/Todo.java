package com.example.todo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Todo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1670706223931167718L;

	private Long id;
	
	private String description;
	
	private boolean completed;
	
	private Date createdOn = new Date();
	
	public Todo() {
		super();
	}

	public Todo(Long id, String description, boolean completed, Date createdOn) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
		this.createdOn = createdOn;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(nullable=false, updatable=false)
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}
