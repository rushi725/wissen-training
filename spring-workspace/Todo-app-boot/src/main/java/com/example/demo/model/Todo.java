package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Todos")
public class Todo {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	int id;
	private String title;
	private String body;
	@Column(name = "cdate")
	private LocalDateTime dateOfCreation;
	@Enumerated(EnumType.STRING)
	private Completed completed;
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
	public Completed getCompleted() {
		return completed;
	}
	public void setCompleted(Completed completed) {
		this.completed = completed;
	}

}
