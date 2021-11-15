package com.sps.todoapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sps.todoapp.exception.ResourceNotFoundException;
import com.sps.todoapp.model.Todo;
import com.sps.todoapp.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping("/todoList")
	public String getAllTodos(ModelMap model, HttpServletRequest req) {
		List<Todo> todos = service.getAllTodos();
		req.setAttribute("todos", todos);
		return "todo/todoList";
	}
	
	@PostMapping("/todoAdd")
	public String createTodo(@ModelAttribute Todo todo, BindingResult result, HttpServletRequest req) {
		
		if (null != todo.getId())
			service.update(todo, null);
		else
			service.create(todo);
		List<Todo> todos = service.getAllTodos();
		req.setAttribute("todos", todos);
		return "todo/todoList";
	}
	

	@GetMapping("/todoAdd")
	public String addTodo(HttpServletRequest req) {
		Todo todo = (Todo) req.getAttribute("todo");
		if (null != todo)
		req.setAttribute("todo", service.getTodoDetailsById(todo.getId()));
		return "todo/todoAdd";
	}
	

	
	@PostMapping("/todoUpdate")
	public String updateTodo(@ModelAttribute Todo todo, BindingResult result, HttpServletRequest req) {
		
		service.update(todo, null);
		List<Todo> todos = service.getAllTodos();
		req.setAttribute("todos", todos);
		return "todo/todoList";
	}

	@GetMapping("/todoEdit")
	public String editTodo1(@RequestParam("id") Long id, HttpServletRequest req, @ModelAttribute Todo todo) {
		Todo dbTodo = service.getTodoDetailsById(id);
		todo.setId(dbTodo.getId());
		todo.setName(dbTodo.getName());
		req.setAttribute("todo", dbTodo);
		return "todo/todoAdd";
//		return "redirect:/todo/todoAdd";
		
	}
	
	@GetMapping("/todoDelete")
	public String deleteTodo(@RequestParam("id") Long id, HttpServletRequest req) 
			throws ResourceNotFoundException {
		service.delete(id);
		req.setAttribute("todoitems", service.getAllTodos());
		req.setAttribute("successMsg", "Task deleted successfully");
		return "todo/todoList";
	}
	

}
