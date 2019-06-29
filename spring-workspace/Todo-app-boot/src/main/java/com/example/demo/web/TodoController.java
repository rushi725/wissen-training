package com.example.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

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
		model.addAttribute(todos);
		return "todo-list";		
	}
	
	@RequestMapping(value = "/todos/delete", method=RequestMethod.GET)
	public void deleteTodo(@RequestParam int id, HttpServletResponse resp) throws IOException {
		todoRepository.deleteById(id);
		resp.sendRedirect("/todos");
		
	}
	
	@RequestMapping(value = "/todos/edit", method = RequestMethod.GET)
	public String editTodos(@RequestParam int id) {
		return "todo-edit";
	}
	
	@RequestMapping(value = "/todo/edit", method = RequestMethod.POST)
	public String editTodos(@ModelAttribute Todo todo,Model model) throws IOException {
		todoRepository.save(todo);
		model.addAttribute("todo",todo);
		return "todo-view";
	}
	
	@RequestMapping(value = "/todos/add", method = RequestMethod.GET)
	public String addTodos() {
		return "todo-add";
	}
	
	@RequestMapping(value = "/todo/add", method = RequestMethod.POST)
	public String addTodos(@ModelAttribute Todo todo,Model model) throws IOException {
		todoRepository.save(todo);
		model.addAttribute("todo",todo);
		return "view-todo";
	}
	
	@RequestMapping(value = "/todos/view",method = RequestMethod.GET)
	public String viewTodos(@RequestParam int id,Model model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "view-todo";
	}
	
	@RequestMapping(value = "/todo/sort", method = RequestMethod.GET)
	public String sortTodos() {
		Sort sort = new ArrayList.asList("id");
		List<Todo> todos = todoRepository.findAll(sort);
	}
	
	
	

}
