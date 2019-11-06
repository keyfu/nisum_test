package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.PersonaInfo;
import com.example.services.PersonaInfoServiceImpl;

@RestController
@RequestMapping("/api")
public class PersonaInfoController {
	
	@Autowired
	PersonaInfoServiceImpl personaInfoServiceImpl;

	@GetMapping("/persona")
	public List<PersonaInfo> getPersons() {
		
		return personaInfoServiceImpl.getPersons();
		
	}
	
	@PostMapping("/persona")
	public PersonaInfo addPerson(@RequestBody PersonaInfo persona) {
		
		return personaInfoServiceImpl.addPersonaInfo(persona);
		
	}
	
	@GetMapping("/persona/{id}")
	public PersonaInfo getPerson(@PathVariable(name = "id") Long id) {
		
		return personaInfoServiceImpl.getPersonById(id);
		
	}
	
	@PutMapping("/persona/{id}")
	public PersonaInfo updatePerson(@PathVariable(name = "id") Long id, @RequestBody PersonaInfo person) {
		
		PersonaInfo personaSelected = personaInfoServiceImpl.getPersonById(id);
		
		personaSelected.setName(person.getName());
		personaSelected.setLast_name(person.getLast_name());
		personaSelected.setAddress(person.getAddress());
		personaSelected.setSimple_phone_number(person.getSimple_phone_number());
		personaSelected.setHair_colour(person.getHair_colour());
		
		return personaInfoServiceImpl.updatePersonaInfo(personaSelected);
		
	}
	
	@DeleteMapping("/persona/{id}")
	public void deletePerson(@PathVariable(name = "id") Long id) {
		
		personaInfoServiceImpl.deletePersonaInfo(id);
		
	}
	
}
