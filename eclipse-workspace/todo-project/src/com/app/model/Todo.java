package com.app.model;

import java.time.LocalDateTime;

public class Todo {
	static int count=1;
	private int id;
	private String title;
	private boolean completed;
	private LocalDateTime date;
	
	
	public Todo(String title){
		this.title = title;
		//this.completed = false;
		this.date = LocalDateTime.now();
		this.id = count;
		count++;
	}
	
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
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[ " + id + " " + title + " " + completed + " " + date + "]\n";
	}

}
