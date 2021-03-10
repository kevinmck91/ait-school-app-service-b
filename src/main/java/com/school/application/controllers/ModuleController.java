package com.school.application.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.school.application.dtos.Module;
import com.school.application.exceptions.ModuleAlreadyExistsException;
import com.school.application.exceptions.ModuleNotFoundException;
import com.school.application.repositories.ModuleRepository;

@RestController
public class ModuleController {

	@Autowired
	private ModuleRepository moduleRepository;

	@GetMapping("modules/")
	public List<Module> getAllModules() {
		return moduleRepository.findAll();
	}
	
	@GetMapping("modules/{moduleCode}/")
	public Optional<Module> getModuleByModuleCode(@PathVariable String moduleCode) {
		
		Optional<Module> foundModule = moduleRepository.findByModuleCode(moduleCode);
		
		if(foundModule.isPresent())
			return foundModule;
		else
			throw new ModuleNotFoundException("Unable to find Module: " + moduleCode);
		
	}
	
	@PostMapping("modules/")
	public ResponseEntity createModule(@RequestBody Module newModule) {

		Optional<Module> foundModule = moduleRepository.findByModuleCode(newModule.getModuleCode());

		if (!foundModule.isPresent())		// student does not exist
		{
			moduleRepository.save(newModule);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newModule.getId()).toUri();
			return ResponseEntity.created(location).build();
		} 
		else 
		{
			throw new ModuleAlreadyExistsException("The Module code already exists : " + newModule.getModuleCode());
		}

	}

}
