package com.example.validators;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HairColourValidator implements
  ConstraintValidator<HairColourConstraint, String> {
 
	private static final List<String> HAIR_COLOUR_VALID = Arrays.asList(new String[] {"black", "red", "yellow", "brown", "white"});
	
    @Override
    public void initialize(HairColourConstraint hairColourField) {
    }
 
    @Override
    public boolean isValid(String hairColourField,
      ConstraintValidatorContext cxt) {
        if ( HAIR_COLOUR_VALID.indexOf(hairColourField) != -1 ) {
        	return true;
        }
        return false;
    }
}
