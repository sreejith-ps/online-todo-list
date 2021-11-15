package com.sps.todoapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
		User user = userService.validateUser(username, password);

		if (null != user) {
			model.put("username", username);
			model.put("password", password);

			HttpSession session = request.getSession(true); 
			session.setAttribute("user", user);
			session.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
			session.setMaxInactiveInterval(60); 
			request.setAttribute("todos", service.getAllTodos(user.getId()));
			return "todo/todoList";
		}
		model.put("errorMsg", "Invalid username/password");
		return "login";
	}

}
