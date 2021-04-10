package com.school.students.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class StudentGenericError extends RuntimeException {

	public StudentGenericError(String message) {
		super(message);
	}

}
