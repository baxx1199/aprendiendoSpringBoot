package com.baxxy.springboot.form.app.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiedValidator implements ConstraintValidator<RequiedF, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value==null || value.isEmpty() || value.isBlank()){
			return false;
		}	
		
		return true;
	}

}
