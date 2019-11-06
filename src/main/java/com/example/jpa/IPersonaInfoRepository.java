package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PersonaInfo;

@Repository
public interface IPersonaInfoRepository extends JpaRepository<PersonaInfo, Long> {

}
