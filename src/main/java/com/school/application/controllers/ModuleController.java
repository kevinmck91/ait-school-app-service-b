package com.school.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.application.dtos.Module;
import com.school.application.repositories.ModuleRepository;

@RestController
public class ModuleController {

	@Autowired
	private ModuleRepository moduleRepository;

	@GetMapping("modules")
	public List<Module> getAllModules() {
		return moduleRepository.findAll();
	}

}
