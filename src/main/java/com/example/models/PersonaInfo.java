package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;

import com.example.validators.OnlyLetterConstraint;

@Entity
@Table(name = "persona")
public class PersonaInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OnlyLetterConstraint
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "simple_phone_number")
	private Long simple_phone_number;
	
	@Column(name = "hair_colour")
	private String hair_colour;

	public PersonaInfo() {}

	public PersonaInfo(Long id, String name, String last_name, String address, Long simple_phone_number,
			String hair_colour) {
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.simple_phone_number = simple_phone_number;
		this.hair_colour = hair_colour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getSimple_phone_number() {
		return simple_phone_number;
	}

	public void setSimple_phone_number(Long simple_phone_number) {
		this.simple_phone_number = simple_phone_number;
	}

	public String getHair_colour() {
		return hair_colour;
	}

	public void setHair_colour(String hair_colour) {
		this.hair_colour = hair_colour;
	}

	
	
	
	
}
