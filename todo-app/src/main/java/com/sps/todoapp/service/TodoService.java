package com.sps.todoapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.todoapp.model.Todo;
import com.sps.todoapp.repository.TodoRepository;

@Service
@Transactional
public class TodoService {

	@Autowired
	TodoRepository repository;

	public Todo getTodoDetailsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Todo create(Todo todo) {
		return repository.save(todo);
	}

	public Todo update(Todo todo, Long todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
