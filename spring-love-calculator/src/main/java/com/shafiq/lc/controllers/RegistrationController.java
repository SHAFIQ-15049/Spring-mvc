package com.shafiq.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shafiq.lc.api.CommunicationDTO;
import com.shafiq.lc.api.Phone;
import com.shafiq.lc.api.UserRegistrationDTO;
import com.shafiq.lc.propertyeditor.NamePropertyEditor;
import com.shafiq.lc.validator.EmailValidator;
import com.shafiq.lc.validator.UserNameValidator;

@Controller
public class RegistrationController {

	@RequestMapping("/register")
	public String registrationPage(@ModelAttribute("userRegistrationInfo") UserRegistrationDTO userRegistrationDTO)
	{
		System.out.println("Inside registrationPage method.");
		
		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("22334455");
		
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		
		userRegistrationDTO.setCommunicationDTO(communicationDTO);
		
		return "user-registration-page";
	}

	@RequestMapping("/register-success")
	public String processRegistration(@Valid @ModelAttribute("userRegistrationInfo") UserRegistrationDTO userRegistrationDTO, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			List<ObjectError> allErrors = result.getAllErrors();
			
			for(ObjectError errors :allErrors)
			{
				System.out.println(errors);
			}
			
			return "user-registration-page";
		}
		
		System.out.println("Inside processRegistration method.");
		return "registration-success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		System.out.println("We are inside initbinder");
		//binder.setDisallowedFields("name");
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class,"name",editor);
		
		//namePropertyeditor
		NamePropertyEditor nameEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name",nameEditor);
		
		
		//register userName validator
		
		binder.addValidators(new UserNameValidator());
		
		//register email validator
		
		binder.addValidators(new EmailValidator());
		
		
	}

}
