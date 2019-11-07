package com.example.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyLetterValidator implements
  ConstraintValidator<OnlyLetterConstraint, String> {
 
    @Override
    public void initialize(OnlyLetterConstraint onlyLetterField) {
    }
 
    @Override
    public boolean isValid(String onlyLetterField,
      ConstraintValidatorContext cxt) {
        for ( int i=0; i<onlyLetterField.length(); i++ ) {
        	char c = onlyLetterField.charAt (i);
        	if ( (c < 'a' ||  c > 'z') && (c < 'A' ||  c > 'Z') ) {
        		return false;
        	}
        }
        return true;
    }
}
