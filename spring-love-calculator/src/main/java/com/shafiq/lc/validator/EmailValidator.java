package com.shafiq.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shafiq.lc.api.UserRegistrationDTO;

public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
		
		//whether the email is ending with seleniumexpress.com
		String email = ((UserRegistrationDTO)object).getCommunicationDTO().getEmail();
		
		if(!email.endsWith("seleniumexpress.com"))
		{
			errors.rejectValue("communicationDTO.email","email.invalidDomain");
		}
		
	}

}
