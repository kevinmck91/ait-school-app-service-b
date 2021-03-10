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
	
/*	@GetMapping("students/{id}")
	public Optional<Student> getAllStudents(@PathVariable Integer id) {
		return studentRepository.findById(id);
	}*/
	
	@GetMapping("students/{studentNumber}")
	public Optional<Student> getStudentByStudentNumber(@PathVariable String studentNumber) {
		return studentRepository.findByStudentNumber(studentNumber);
	}
	
	@PostMapping("students/")
	public ResponseEntity createWine(@RequestBody Student newStudent) {

		Student savedStudent = studentRepository.save(newStudent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newStudent.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	
}
