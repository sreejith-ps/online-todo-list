package com.sps.todoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sps.todoapp.model.User;
import com.sps.todoapp.service.TodoService;
import com.sps.todoapp.service.UserService;

@Controller
@RequestMapping
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	UserService userService;

	@Autowired
	TodoService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		return "login";
	}
	

//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logout(HttpServletRequest req) {
//		req.setAttribute("mode", "LOGIN");
//		return "login";
//	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam ("username") String username, 
			@RequestParam("password") String password) {
		User user = userService.validateUser(username, password);
		
		if (null != user) {
			model.put("username", username);
	        model.put("password", password);
			return "todo/todoList";
		}
		model.put("errorMsg", "Invalid username/password");
		return "login";
	}
}
