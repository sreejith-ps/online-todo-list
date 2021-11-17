package com.sps.todoapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		Optional<Todo> todo = repository.findById(id); 
		
		if (todo.isPresent())
			repository.deleteById(todo.get().getId());
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Todo changeCheckStatus(Long id, Integer checkStatus) {
		Optional<Todo> todoOp = repository.findById(id); 
		
		if (todoOp.isPresent()) {
			Todo todo = todoOp.get();
			todo.setActiveStatus(checkStatus == 1 ? 2 : 1);
			todo = repository.save(todo);
			return todo;
		}
		return null;
	}
	
	
}
