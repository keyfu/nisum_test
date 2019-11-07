package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.PersonaInfo;
import com.example.jpa.IPersonaInfoRepository;

@Service
public class PersonaInfoServiceImpl implements IPersonaInfoService {

	@Autowired
	IPersonaInfoRepository personaInfoRepository;
	
	@Override
	public List<PersonaInfo> getPersons() {
		
		return personaInfoRepository.findAll();
		
	}

	@Override
	public PersonaInfo addPersonaInfo(PersonaInfo person) {
		
		return personaInfoRepository.save(person);
		
	}

	@Override
	public PersonaInfo updatePersonaInfo(PersonaInfo person) {
		
		return personaInfoRepository.save(person);
		
	}

	@Override
	public void deletePersonaInfo(Long id) {

		personaInfoRepository.deleteById(id);
		
	}
	
	@Override
	public PersonaInfo getPersonById(Long id) {
		
		return personaInfoRepository.findById(id).get();
	
	}

}
