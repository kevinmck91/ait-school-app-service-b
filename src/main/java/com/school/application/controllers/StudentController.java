package com.school.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.application.dtos.Student;
import com.school.application.repositories.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	
}
