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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sps.todoapp.exception.ResourceNotFoundException;
import com.sps.todoapp.model.Todo;

@SpringBootTest
public class TodoServiceTests {

	@Autowired
	TodoService service;
	

	@Test
	public void createTodo() {
		LocalDate d = LocalDate.of(2021, 11, 15);
		Todo todo = new Todo(null, "Complete Assignment", "Complete Assignment", "pending", 
				Date.from(d.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant()) , new Date(), 1);
		when(service.create(todo)).thenReturn(
				new Todo(1L, "Complete Assignment", "Complete Assignment", "pending", 
						Date.from(d.atStartOfDay()
							      .atZone(ZoneId.systemDefault())
							      .toInstant()) , new Date(), 1));
		assertThat(service.create(todo).getId()).isNotNull();
	}
	
	@Test
	public void getAllTodos() {
		LocalDate d = LocalDate.of(2021, 11, 15);
		when(service.getAllTodos()).thenReturn(Stream.of(new Todo(1L, "Start Assignment", "Start Assignment", "pending", 
				Date.from(d.atStartOfDay()
					      .atZone(ZoneId.systemDefault())
					      .toInstant()) , new Date(), 1),
				new Todo(2L, "Complete Assignment", "Complete Assignment", "pending", 
						Date.from(d.atStartOfDay()
							      .atZone(ZoneId.systemDefault())
							      .toInstant()) , new Date(), 1)).collect(Collectors.toList()));
		assertEquals(2, service.getAllTodos());
	}
	
	@Test
	public void getTodoById() throws ResourceNotFoundException {
		Long id = 1L;
		LocalDate d = LocalDate.of(2021, 11, 15);
		when(service.getTodoDetailsById(id)).thenReturn(new Todo(2L, "Complete Assignment", "Complete Assignment", "pending", 
				Date.from(d.atStartOfDay()
					      .atZone(ZoneId.systemDefault())
					      .toInstant()) , new Date(), 1));
		assertNotNull(service.getTodoDetailsById(id));
	}
	
	
	@Test
	public void delete() throws ResourceNotFoundException {
		LocalDate d = LocalDate.of(2021, 11, 15);
		Todo todo = new Todo(1L, "Complete Assignment", "Complete Assignment", "pending", 
				Date.from(d.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant()) , new Date(), 1);
		service.delete(1L);
		verify(service, times(1)).delete(todo.getId());
	}
}
