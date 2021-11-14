package com.sps.todoapp.util;

import java.util.HashMap;
import java.util.Map;

import com.sps.todoapp.model.User;

public class Helper {
	
	private static Map<String, User> userMap = new HashMap<>();
	
	static {
		userMap.put("admin", new User(1, "Admin", "Global", "admin", "admin"));
		userMap.put("user", new User(1, "User", "Global", "user", "user"));
	}
	
	public static Map<String, User> getUsers() {
		return userMap;
	}

}
