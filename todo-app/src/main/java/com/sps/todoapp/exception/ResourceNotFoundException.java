package com.sps.todoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -6284237766597189556L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
