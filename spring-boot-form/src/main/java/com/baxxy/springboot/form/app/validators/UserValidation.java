package com.baxxy.springboot.form.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.baxxy.springboot.form.app.models.domain.User;

@Component
public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//User user = (User)target;
		
		
		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.ur.name");
		
		/*if(user.getName().isEmpty()) {
			errors.rejectValue("name", "NotEmpty.ur.name");
		}*/
		
		/*if(!user.getId().matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
			errors.rejectValue("id", "pattern.ur.id");
		}*/
		
	}

}
