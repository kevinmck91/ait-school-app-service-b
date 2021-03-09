package com.school.application;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.school.application.dtos.Module;
import com.school.application.dtos.Student;
import com.school.application.repositories.ModuleRepository;
import com.school.application.repositories.StudentRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModuleRepository moduleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	
	}

}
