package com.sps.todoapp.service;

import java.util.Date;
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
		return repository.findById(id).get(); 
	}

	public List<Todo> getAllTodos(Integer id) {
		return repository.findByUserId(id);
	}

	public Todo create(Todo todo) {
		todo.setModifiedDate(new Date());
		return repository.save(todo);
	}

	public Todo update(Todo todo, Long todoId) {
		todo.setModifiedDate(new Date());
		return repository.save(todo);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
