package com.example.demo.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

import com.example.demo.model.Completed;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class TodoController {
	
	
	@Autowired
	private TodoRepository todoRepository;
	
	
	@RequestMapping(value = "/todos", method=RequestMethod.GET)
	 public String displayList(Model model) {
		List<Todo> todos = todoRepository.findAll();
		model.addAttribute("todo",todos);
		return "todo-list";		
	}
	
	@RequestMapping(value = "/todo/delete", method=RequestMethod.GET)
	public void deleteTodo(@RequestParam int id, HttpServletResponse resp) throws IOException {
		todoRepository.deleteById(id);
		resp.sendRedirect("/todos");
		
	}
	
	@RequestMapping(value = "/todo/edit", method = RequestMethod.GET)
	public String editTodos(@RequestParam int id,Model model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "edit-form";
	}
	
	@RequestMapping(value = "/todo/edit", method = RequestMethod.POST)
	public String editTodos(@ModelAttribute Todo todo,Model model) throws IOException {
		Todo oldTodo = todoRepository.findById(todo.getId()).get();
		System.out.println(todo.getId());
		System.out.println(oldTodo.getDateOfCreation());
		todo.setDateOfCreation(oldTodo.getDateOfCreation());
		todo.setCompleted(oldTodo.getCompleted());
		todoRepository.save(todo);
		model.addAttribute("todo",todo);
		return "todo-view";
	}
	
	@RequestMapping(value = "/todo/add", method = RequestMethod.GET)
	public String addTodos() {
		return "todo-form";
	}
	
	@RequestMapping(value = "/todo/add", method = RequestMethod.POST)
	public void addTodos(@ModelAttribute Todo todo,HttpServletResponse resp) throws IOException {
		todo.setCompleted(Completed.FALSE);
		todo.setDateOfCreation(LocalDateTime.now());
		todoRepository.save(todo);
		//model.addAttribute("todo",todo);
		//return "todo-view";
		resp.sendRedirect("/todos");
	}
	
	@RequestMapping(value = "/todo/view",method = RequestMethod.GET)
	public String viewTodos(@RequestParam int id,Model model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "todo-view";
	}
	
	@RequestMapping(value = "/todo/sortByTitle", method = RequestMethod.GET)
	public String sortTodosByTitle(Model model) {
		Sort sort = new Sort(Direction.ASC,"title");
		List<Todo> todos = todoRepository.findAll(sort);
		model.addAttribute("todo",todos);
		return "todo-list";
		
	}
	
	@RequestMapping(value = "/todo/sortById", method = RequestMethod.GET)
	public String sortTodosById(Model model) {
		Sort sort = new Sort(Direction.ASC,"id");
		List<Todo> todos = todoRepository.findAll(sort);
		model.addAttribute("todo",todos);
		return "todo-list";
		
	}
	
	
	@RequestMapping(value = "/todo/sortByDate", method = RequestMethod.GET)
	public String sortTodosByDate(Model model) {
		Sort sort = new Sort(Direction.ASC,"dateOfCreation");
		List<Todo> todos = todoRepository.findAll(sort);
		model.addAttribute("todo",todos);
		return "todo-list";
		
	}
	
	
	@RequestMapping(value = "/todo/filterByCompleted", method = RequestMethod.GET)
	public String filterByCompleted(Model model) {
		List<Todo> todos = todoRepository.findAllByCompleted(Completed.TRUE);
		model.addAttribute("todo",todos);
		return "todo-list";
		
	}
	
	
	
	@RequestMapping(value = "/todo/clearCompleted", method = RequestMethod.GET)
	public void clearCompleted(HttpServletResponse resp) throws IOException {
		List<Todo> list = todoRepository.findAllByCompleted(Completed.TRUE);
		todoRepository.deleteAll(list);
		resp.sendRedirect("/todos");
		
	}
	
	@RequestMapping(value =  "/todo/toggle", method = RequestMethod.GET)
	public void toggleCompleted(@RequestParam int id,HttpServletResponse resp) throws IOException {
		Todo todo = todoRepository.findById(id).get();
		if(todo.getCompleted() == Completed.TRUE)
			todo.setCompleted(Completed.FALSE);
		else
			todo.setCompleted(Completed.TRUE);
		todoRepository.save(todo);
		resp.sendRedirect("/todos");
	}

}
