package com.sps.todoapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sps.todoapp.model.User;
import com.sps.todoapp.service.UserService;
import com.sps.todoapp.util.Helper;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String home() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(ModelMap model, @RequestParam ("username") String username, 
			@RequestParam("password") String password) {
		
		
		User user = userService.doLogin(username, password);
		model.put("errorMsg", "Invalid username/password");
		return "login";
	}
}
