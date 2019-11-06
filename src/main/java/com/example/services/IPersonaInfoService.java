package com.example.services;

import java.util.List;

import com.example.models.PersonaInfo;

public interface IPersonaInfoService {

	public List<PersonaInfo> getPersons();
	
	public PersonaInfo addPersonaInfo(PersonaInfo persona);
	
	public PersonaInfo updatePersonaInfo(PersonaInfo persona);
	
	public void deletePersonaInfo(Long id);
	
	public PersonaInfo getPersonById(Long id);
}
