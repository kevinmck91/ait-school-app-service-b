package com.school.application.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping("students/{studentNumber}")
	public Optional<Student> getStudentByStudentNumber(@PathVariable String studentNumber) {
		return studentRepository.findByStudentNumber(studentNumber);
	}
	
	@PostMapping("students/")
	public ResponseEntity createWine(@RequestBody Student newStudent) {

		// If student number already exists , TODO throw an error
		if(getStudentByStudentNumber(newStudent.getStudentNumber()).isPresent()) {
			System.out.println("Student already exists");
			return null; 
		}
		else {
			Student savedStudent = studentRepository.save(newStudent);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newStudent.getId()).toUri();
			return ResponseEntity.created(location).build();
		}

	}

	
}
