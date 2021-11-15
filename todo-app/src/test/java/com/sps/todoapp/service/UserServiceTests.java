package com.sps.todoapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sps.todoapp.model.User;
import com.sps.todoapp.service.UserService;


@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	UserService userService;
	
	
//	@Test
	public void loginTest() {
		String userName = "admin";
		String password = "password";
		when(userService.validateUser(userName, password)).thenReturn(
				new User(1, "Admin", "Global", "admin", "admin"));
		assertEquals(1,  userService.validateUser(userName, password).getId());
	}
}
