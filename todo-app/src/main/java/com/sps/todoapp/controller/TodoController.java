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
		req.setAttribute("todos", service.getAllTodos());
		return "todo/todoList";
	}

	@PostMapping("/todoAdd")
	public String createTodo(@ModelAttribute Todo todo, BindingResult result, HttpServletRequest req) {
		service.create(todo);
		req.setAttribute("todos", service.getAllTodos());
		req.setAttribute("successMsg", "Task added successfully");
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
		req.setAttribute("todos", service.getAllTodos());
		req.setAttribute("successMsg", "Task updated successfully");
		return "todo/todoList";
	}

	@GetMapping("/todoEdit")
	public String editTodo(@RequestParam("id") Long id, HttpServletRequest req, @ModelAttribute Todo todo) {
		Todo dbTodo = service.getTodoDetailsById(id);
		todo.setId(dbTodo.getId());
		todo.setName(dbTodo.getName());
		todo.setDescription(dbTodo.getDescription());
		todo.setStatus(dbTodo.getStatus());
		todo.setTargetDate(dbTodo.getTargetDate());
		req.setAttribute("todo", dbTodo);
		return "todo/todoAdd";

	}

	@GetMapping("/todoDelete")
	public String deleteTodo(@RequestParam("id") Long id, HttpServletRequest req) throws ResourceNotFoundException {
		service.delete(id);
		req.setAttribute("todos", service.getAllTodos());
		req.setAttribute("successMsg", "Task deleted successfully");
		return "todo/todoList";
	}

}
