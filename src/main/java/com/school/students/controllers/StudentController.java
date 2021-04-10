package com.school.students.controllers;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.school.students.dtos.Student;
import com.school.students.exceptions.StudentAlreadyExistsException;
import com.school.students.exceptions.StudentGenericError;
import com.school.students.exceptions.StudentNotFoundException;
import com.school.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("students/")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("students/{studentNumber}/")
	public Optional<Student> getStudentByStudentNumber(@PathVariable String studentNumber) {
		
		Optional<Student> foundStudent = studentRepository.findByStudentNumber(studentNumber);

		if (foundStudent.isPresent())
			return foundStudent;
		else
			throw new StudentNotFoundException("Unable to find Student Number: " + studentNumber);
	}

	@GetMapping("students/yearOfBirthBetween/")
	public List<Student> getStudentBetweenBirthYears(@RequestParam(required=true) int yearLower, @RequestParam(required=true) int yearUpper) {

		// Convert input years into two Dates and use dates to query database
		String lowerBoundDateString = "01/01/" + yearLower;
		String upperBoundDateString = "31/12/" + yearUpper;

		SimpleDateFormat simpleDateFormatter = 	new SimpleDateFormat("dd/MM/yyyy");

		Date lowerBoundDate;
		Date upperBoundDate;

		try{
			lowerBoundDate = simpleDateFormatter.parse(lowerBoundDateString);
			upperBoundDate = simpleDateFormatter.parse(upperBoundDateString);

		} catch (Exception e){
			throw new StudentGenericError("Error parsing years: " + yearLower + " and " + yearUpper);
		}

		if(lowerBoundDate.after(upperBoundDate)){
			throw new StudentGenericError("Year inputs incorrect YearLower must be before YearUpper");
		}

		List<Student> foundStudents = studentRepository.findAllByDateOfBirthBetween(lowerBoundDate, upperBoundDate);

		if (foundStudents.size() > 0)
			return foundStudents;
		else
			throw new StudentNotFoundException("No students born between years " + yearLower + " and " + yearUpper);

	}

	@PostMapping("students/")
	public ResponseEntity createStudent(@RequestBody Student newStudent) {

		if (newStudent.getStudentNumber().length() != 5)
			throw new StudentGenericError("Student number must be exactly 5 characters");

		// Check to see if the Student number already exists
		Optional<Student> foundStudent = studentRepository.findByStudentNumber(newStudent.getStudentNumber());

		if (!foundStudent.isPresent())		// student does not exist
		{
			studentRepository.save(newStudent);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newStudent.getId()).toUri();
			return ResponseEntity.created(location).build();
		} 
		else 
		{
			throw new StudentAlreadyExistsException("The student number already exists : " + newStudent.getStudentNumber());
		}

	}

	@Transactional
	@DeleteMapping("students/{studentNumber}/")
	public void deleteStudentByStudentNumber(@PathVariable String studentNumber) {

		try {
			studentRepository.deleteByStudentNumber(studentNumber);
		} catch (Exception e) {
			throw new StudentNotFoundException("Unable to find Student Number: " + studentNumber + e);
		}

	}

	@PutMapping("students/")
	public ResponseEntity updateStudent(@RequestBody Student newStudent) {

		String studentNumber = newStudent.getStudentNumber();
		studentRepository.findByStudentNumber(studentNumber);

		System.out.println(studentRepository.findByStudentNumber(studentNumber));

		if(!studentRepository.findByStudentNumber(studentNumber).isPresent())
		{
			System.out.println("Add New" + newStudent.getStudentNumber());
			studentRepository.save(newStudent);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else
		{
			newStudent.setId(studentRepository.findByStudentNumber(studentNumber).get().getId());
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newStudent.getId()).toUri();
			return ResponseEntity.created(location).build();
		}

	}

}
