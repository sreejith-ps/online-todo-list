package com.sps.todoapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sps.todoapp.exception.ResourceNotFoundException;
import com.sps.todoapp.model.Todo;
import com.sps.todoapp.model.User;
import com.sps.todoapp.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoService service;

	@GetMapping("/todoList")
	public String getAllTodos(ModelMap model, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (null == session || null == session.getAttribute("user")) {
			return "login";
		}
		User user = (User) session.getAttribute("user");
		req.setAttribute("todos", service.getAllTodos(user.getId()));
		return "todo/todoList";
	}

	@PostMapping("/todoAdd")
	public String createTodo(@ModelAttribute Todo todo, BindingResult result, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (null == session || null == session.getAttribute("user")) {
			return "login";
		}

		User user = (User) session.getAttribute("user");
		String shouldSave = (String) session.getAttribute("save");
		if (null != shouldSave && "true".equals(shouldSave)) {
			todo.setUserId(user.getId());
			service.create(todo);
			req.setAttribute("successMsg", "Task added successfully");
			session.setAttribute("save", "false");
		}
		req.setAttribute("todos", service.getAllTodos(user.getId()));
		return "todo/todoList";
	}

	@GetMapping("/todoAdd")
	public String addTodo(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Todo todo = (Todo) req.getAttribute("todo");
		if (null != todo)
			req.setAttribute("todo", service.getTodoDetailsById(todo.getId()));

		session.setAttribute("save", "true");
		return "todo/todoAdd";
	}

	@PostMapping("/todoUpdate")
	public String updateTodo(@ModelAttribute Todo todo, BindingResult result, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (null == session || null == session.getAttribute("user")) {
			return "login";
		}

		User user = (User) session.getAttribute("user");
		todo.setUserId(user.getId());
		service.update(todo, null);
		req.setAttribute("successMsg", "Task updated successfully");

		req.setAttribute("todo", new Todo());
		req.setAttribute("todos", service.getAllTodos(user.getId()));
		return "todo/todoList";
	}

	@GetMapping("/todoEdit")
	public String editTodo(@RequestParam("id") Long id, HttpServletRequest req, @ModelAttribute Todo todo) {
		Todo dbTodo = service.getTodoDetailsById(id);
		todo.setId(dbTodo.getId());
		todo.setName(dbTodo.getName());
		todo.setDescription(dbTodo.getDescription());
		todo.setStatus(dbTodo.getStatus());
		todo.setTargetDate(dbTodo.getTargetDate());
		todo.setUserId(dbTodo.getUserId());
		req.setAttribute("todo", todo);
		return "todo/todoAdd";

	}

	@GetMapping("/todoDelete")
	public String deleteTodo(@RequestParam("id") Long id, HttpServletRequest req) throws ResourceNotFoundException {
		HttpSession session = req.getSession(false);
		if (null == session || null == session.getAttribute("user")) {
			return "login";
		}
		User user = (User) session.getAttribute("user");
		service.deleteById(id);
		req.setAttribute("todos", service.getAllTodos(user.getId()));
		req.setAttribute("successMsg", "Task deleted successfully");
		return "todo/todoList";
	}
	
	@GetMapping("/check")
	public String checkTodo(@RequestParam("id") Long id, @RequestParam("checkStatus") Integer checkStatus, HttpServletRequest req, @ModelAttribute Todo todo) {
		HttpSession session = req.getSession(false);
		if (null == session || null == session.getAttribute("user")) {
			return "login";
		}
		User user = (User) session.getAttribute("user");
		service.changeCheckStatus(id, checkStatus);
		req.setAttribute("todos", service.getAllTodos(user.getId()));
		return "todo/todoList";

	}

}
