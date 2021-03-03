package com.school.application.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.application.dtos.Student;

@Component
public class StudentDAO {

	List<Student> studentList = new ArrayList(Arrays.asList(
				new Student(1, "John", "Smith", "23/04/2000", 2),
				new Student(1, "Mary", "Murphy", "13/02/1999", 3),
				new Student(1, "Frank", "clark", "15/08/2001", 4)
			));
	
	
	public List<Student> getAllStudents() {
		return studentList;
	}
	

	
}
