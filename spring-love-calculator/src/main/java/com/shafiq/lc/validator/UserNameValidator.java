package com.shafiq.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shafiq.lc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

	//check if the username validator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	//We need to write our custom validator logic here
	@Override
	public void validate(Object object, Errors errors) { 

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName","userName.empty", "userName can't be empty");
		
		String userName = ((UserRegistrationDTO)object).getUserName();
		
		if(!userName.contains("_"))
		{
			errors.rejectValue("userName", "userName.invalidString", "userName must contain a'-' ");
		}
	}

}
