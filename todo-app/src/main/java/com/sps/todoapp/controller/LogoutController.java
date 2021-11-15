package com.sps.todoapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class LogoutController {

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
	         HttpServletResponse response) throws IOException {
	      HttpSession session = request.getSession(false);
	      session.removeAttribute("user");
	      session.getMaxInactiveInterval();
	      
		return "redirect:/login";
	}

}
