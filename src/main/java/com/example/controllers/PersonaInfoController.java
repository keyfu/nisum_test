package com.example.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helpers.Responses;
import com.example.models.PersonaInfo;
import com.example.models.ResponseApi;
import com.example.services.PersonaInfoServiceImpl;

@RestController
@RequestMapping("/api")
public class PersonaInfoController {

	@Autowired
	PersonaInfoServiceImpl personaInfoServiceImpl;

	@Autowired
	Responses<PersonaInfo> responsesPersonaInfo;

	@Autowired
	Responses<List<PersonaInfo>> responsesListPersonaInfo;

	@GetMapping("/persona")
	public ResponseApi<List<PersonaInfo>> getPersons() {

		return responsesListPersonaInfo.sendResponseOkData(personaInfoServiceImpl.getPersons());

	}

	@PostMapping("/persona")
	public ResponseEntity<ResponseApi<PersonaInfo>> addPerson(@Valid @RequestBody PersonaInfo persona,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<ResponseApi<PersonaInfo>>(
					responsesPersonaInfo.sendResponseError("Datos Inválidos"), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseApi<PersonaInfo>>(
				responsesPersonaInfo.sendResponseOkData(personaInfoServiceImpl.addPersonaInfo(persona)), HttpStatus.OK);

	}

	@GetMapping("/persona/{id}")
	public ResponseEntity<ResponseApi<PersonaInfo>> getPerson(@PathVariable(name = "id") Long id) {

		PersonaInfo persona = personaInfoServiceImpl.getPersonById(id);

		// No se encontró ninguna persona
		if (persona == null)
			return new ResponseEntity<ResponseApi<PersonaInfo>>(
					responsesPersonaInfo.sendResponseError("Persona no encontrada"), HttpStatus.NOT_FOUND);

		return new ResponseEntity<ResponseApi<PersonaInfo>>(
				responsesPersonaInfo.sendResponseOkData(personaInfoServiceImpl.getPersonById(id)), HttpStatus.OK);

	}

	@PutMapping("/persona/{id}")
	public ResponseEntity<ResponseApi<PersonaInfo>> updatePerson(@PathVariable(name = "id") Long id,
			@Valid @RequestBody PersonaInfo person, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<ResponseApi<PersonaInfo>>(
					responsesPersonaInfo.sendResponseError("Datos Inválidos"), HttpStatus.BAD_REQUEST);
		}

		PersonaInfo personSelected = personaInfoServiceImpl.getPersonById(id);

		// No se encontró ninguna persona
		if (personSelected == null) {
			return new ResponseEntity<ResponseApi<PersonaInfo>>(
					responsesPersonaInfo.sendResponseError("Persona no encontrada"), HttpStatus.NOT_FOUND);
		}

		personSelected.setName(person.getName());
		personSelected.setLast_name(person.getLast_name());
		personSelected.setAddress(person.getAddress());
		personSelected.setSimple_phone_number(person.getSimple_phone_number());
		personSelected.setHair_colour(person.getHair_colour());

		return new ResponseEntity<ResponseApi<PersonaInfo>>(
				responsesPersonaInfo.sendResponseOkData(personaInfoServiceImpl.updatePersonaInfo(personSelected)),
				HttpStatus.OK);

	}

	@DeleteMapping("/persona/{id}")
	public ResponseEntity<ResponseApi<PersonaInfo>> deletePerson(@PathVariable(name = "id") Long id) {

		PersonaInfo personSelected = personaInfoServiceImpl.getPersonById(id);

		// No se encontró ninguna persona
		if (personSelected == null) {
			return new ResponseEntity<ResponseApi<PersonaInfo>>(
					responsesPersonaInfo.sendResponseError("Persona no encontrada"), HttpStatus.NOT_FOUND);
		}

		personaInfoServiceImpl.deletePersonaInfo(id);
		
		return new ResponseEntity<ResponseApi<PersonaInfo>>(
				responsesPersonaInfo.sendResponseOkData(personSelected),
				HttpStatus.OK);

	}

}
