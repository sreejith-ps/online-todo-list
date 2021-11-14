package com.sps.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sps.todoapp.exception.ResourceNotFoundException;
import com.sps.todoapp.model.Todo;
import com.sps.todoapp.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping("/{id}")
	public Todo getTodoDetails(@RequestParam("id") Long id) throws ResourceNotFoundException {
		Todo Todo = service.getTodoDetailsById(id);
		return Todo;
	}

	@GetMapping
	public List<Todo> getTodos() {
		return TodoService.getAllTodos();
	}

	@PostMapping
	public Todo createTodo(@RequestBody Todo Todo) {
		return TodoService.create(Todo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @RequestParam("id") Long id) 
			throws ResourceNotFoundException {
		Todo modifiedTodo = TodoService.update(todo, id);
		return ResponseEntity.ok(modifiedTodo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteTodo(@RequestParam("id") Long id) 
			throws ResourceNotFoundException {
		TodoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateStatus(@RequestBody Todo todo, @RequestParam("id") Long id) 
			throws ResourceNotFoundException {
		Todo modifiedTodo = TodoService.update(todo, id);
		return ResponseEntity.ok(modifiedTodo);
	}

}
