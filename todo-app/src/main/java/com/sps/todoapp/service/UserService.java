package com.sps.todoapp.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.sps.todoapp.model.User;
import com.sps.todoapp.util.Helper;

@Service
public class UserService {

	public User validateUser(String username, String password) {
		Map<String, User> userMap = Helper.getUsers();
		User user = userMap.get(username);
		
		if (null != user  && username.equals(user.getUsername()) && 
				password.equals(user.getPassword()))
			return user;
		return null;
	}

}
