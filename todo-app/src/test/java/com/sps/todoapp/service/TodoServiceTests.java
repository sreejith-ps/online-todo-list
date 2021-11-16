package com.sps.todoapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sps.todoapp.exception.ResourceNotFoundException;
import com.sps.todoapp.model.Todo;
import com.sps.todoapp.repository.TodoRepository;

@SpringBootTest
public class TodoServiceTests {

	@Autowired
	TodoService service;
	

	@MockBean
	private TodoRepository repository;

	@Test
	public void createTodo() {
		LocalDate d = LocalDate.of(2021, 11, 15);
		Todo todo = new Todo(null, "Complete Assignment", "Complete Assignment", "pending", 
				Date.from(d.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant()) , new Date(), 1);
		when(repository.save(todo)).thenReturn(
				new Todo(1L, "Complete Assignment", "Complete Assignment", "pending", 
						Date.from(d.atStartOfDay()
							      .atZone(ZoneId.systemDefault())
							      .toInstant()) , new Date(), 1));
		assertThat(service.create(todo).getId()).isNotNull();
	}
	
//	@Test
	public void getAllTodos() {
		LocalDate d = LocalDate.of(2021, 11, 15);
		when(repository.findByUserId(1)).thenReturn(Stream.of(new Todo(1L, "Start Assignment", "Start Assignment", "pending", 
				Date.from(d.atStartOfDay()
					      .atZone(ZoneId.systemDefault())
					      .toInstant()) , new Date(), 1),
				new Todo(2L, "Complete Assignment", "Complete Assignment", "pending", 
						Date.from(d.atStartOfDay()
							      .atZone(ZoneId.systemDefault())
							      .toInstant()) , new Date(), 1)).collect(Collectors.toList()));
		assertEquals(2, service.getAllTodos(1));
	}
	
	@Test
	public void getTodoById() throws ResourceNotFoundException {
		Long id = 1L;
		LocalDate d = LocalDate.of(2021, 11, 15);
		when(repository.findById(id)).thenReturn(Optional.of(new Todo(1L, "Complete Assignment", "Complete Assignment", "pending", 
				Date.from(d.atStartOfDay()
					      .atZone(ZoneId.systemDefault())
					      .toInstant()) , new Date(), 1)));
		assertNotNull(service.getTodoDetailsById(id));
	}
	
	
//	@Test
	public void delete() throws ResourceNotFoundException {
		LocalDate d = LocalDate.of(2021, 11, 15);
		Todo todo = new Todo(1L, "Complete Assignment", "Complete Assignment", "pending", 
				Date.from(d.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant()) , new Date(), 1);
		repository.deleteById(1L);
		verify(service, times(1)).delete(todo.getId());
	}
}
