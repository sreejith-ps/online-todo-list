package com.sps.todoapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sps.todoapp.model.User;
import com.sps.todoapp.service.UserService;


@SpringBootTest
public class LoginControllerTests {
	
	@Autowired
	UserService userService;
	
	

	@Test
	public void getAllBooksTest() {
		String userName = "admin";
		String password = "password";
		when(userService.doLogin(userName, password)).thenReturn(
				new User(1, "Admin", "Global", "admin", "admin"));
		assertEquals(1,  userService.doLogin(userName, password).getId());
	}
}
