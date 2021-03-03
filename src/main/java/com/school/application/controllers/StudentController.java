package com.school.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.application.daos.StudentDAO;
import com.school.application.dtos.Student;

@RestController
public class StudentController {

	@Autowired
	StudentDAO studentDAO;
	
	@GetMapping("students")
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}
	
}
