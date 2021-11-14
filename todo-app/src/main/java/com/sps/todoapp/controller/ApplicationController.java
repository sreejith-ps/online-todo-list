package com.sps.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	

	@GetMapping("/todoList")
	public String todoList() {
		return "todo/todoList";
	}
	
	@GetMapping("/todoAdd")
	public String add() {
		return "todo/todoAdd";
	}

	@GetMapping("/todoUpdate")
	public String update() {
		return "todo/todoAdd";
	}
	
	
	
}
