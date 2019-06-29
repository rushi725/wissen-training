package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Todos")
public class Todo {
	
	private int id;
	private String title;
	private String body;
	private LocalDateTime dateOfCreation;
	boolean completed;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public LocalDateTime getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(LocalDateTime dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	

}
