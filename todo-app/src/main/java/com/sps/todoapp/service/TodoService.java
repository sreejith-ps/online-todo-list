package com.sps.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.todoapp.model.Todo;
import com.sps.todoapp.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository repository;

	public Todo getTodoDetailsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Todo create(Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Todo update(Todo todo, Long todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
