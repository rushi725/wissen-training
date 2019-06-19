package com.app.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
//import java.util.function.ToIntBiFunction;
//import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import com.app.model.Todo;

public class TodoService {
	List<Todo> todoList = new ArrayList<>();
	
	public void addTodo(String title) {
		todoList.add(new Todo(title));
	}
	
	public void editTodo(int id,String title) {
		//todoList.stream().filter(i->i.getId() == id).forEach(i->i.setTitle(title));
		for(Todo ls: todoList) {
			if(ls.getId() == id) {
				ls.setTitle(title);
			}
		}
		
	}
	
	
	public boolean deleteToDo(int id) {
//		try {
//		todoList.stream().filter(i->i.getId() == id).forEach(i->todoList.remove(i));
//		return true;
//		}
//		catch (NullPointerException e){
//			System.out.println(e.getMessage());
//		}
//		return false;
		
		return todoList.removeIf(i->i.getId()==id);
	}
	public void display() {
		for(Todo todo : todoList) {
			System.out.println(todo.toString());
		}
	}
	
	public void completeTodo(int id) {
		//todoList.stream().filter(i->i.getId() == id).forEach(i->i.setCompleted(!i.isCompleted()));
		for(Todo todo : todoList) 
			if(todo.getId() == id)
				todo.setCompleted(!todo.isCompleted());
	}
	
	public void completeAll() {
		
		//todoList.stream().forEach(i->i.setCompleted(true));
		for(Todo todo : todoList) 
				todo.setCompleted(!todo.isCompleted());
	}
	
	public long clearCompleted() {
//		long count = todoList.stream().filter(i->i.isCompleted() == true).count();
//		try {
//		todoList.stream().filter(i->i.isCompleted() == true).forEach(i->todoList.remove(i));
//		}
//		catch (NullPointerException e){
//			System.out.println(e.getMessage());
//		}
//		return count;
		long count = todoList.stream().filter(i->i.isCompleted() == true).count();
		todoList.removeIf(i->i.isCompleted());
		return count;
	}
	
	public List<Todo> filter(Predicate<Todo> p){
		List<Todo> list = todoList
				          .stream()
				          .filter(p)
				          .collect(Collectors.toList()) ;
		return list;
	}
	
	
	public List<Todo> sort(Comparator<Todo> p){
		List<Todo> list = todoList.stream()
				.sorted(p)
				.collect(Collectors.toList());
		
		return list;
		
	}

	
	
	
	
	
	public static void main(String[] args) {
		TodoService td = new TodoService();
		td.addTodo("Do Cycling");
		td.addTodo("Do Walking");
		td.addTodo("Do Prayer");
		td.editTodo(1, "Do Yoga");
		td.deleteToDo(1);
		td.completeTodo(2);
		td.editTodo(2, "Do Running");
		System.out.println(td.clearCompleted());
		td.addTodo("Do Training");
		td.addTodo("Do Practice");
		td.addTodo("Do Reading");
		td.addTodo("Do Calling");
		td.addTodo("Do Watching");
		td.addTodo("Do Sleeping");
		td.addTodo("Do Homework");
		LocalDateTime dt = LocalDateTime.now();
		List<Todo> ls= td.filter(i->i.isCompleted()==false);
		List<Todo> ls2= td.filter(i->i.getDate()==dt);
		List<Todo> ls3= td.sort((o1,o2) -> Integer.compare(o1.getId(), o2.getId()));
		List<Todo> ls4= td.sort((o1,o2) -> o1.getTitle().compareTo(o2.getTitle()));
		System.out.println(ls);
		System.out.println(ls2);
		System.out.println(ls3);
		System.out.println(ls4);
		td.display();
		
	}
	
	
}
