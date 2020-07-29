package com.shafiq.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shafiq.lc.api.UserInfoDTO;

@Controller
public class LCAppController {

//	@RequestMapping("/")
//	public String showHomePage(Model model)
//	{
//		UserInfoDTO userInfoDTO = new UserInfoDTO();
//		model.addAttribute("userInfo", userInfoDTO);
//		
//		return "home-page";
//	}
	
	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO)
	{
		
		return "home-page";
	}
	
//	@RequestMapping("/process-homepage")
//	public String processHomePage(@RequestParam("userName") String userName1,@RequestParam("crushName") String crushName1,Model model)
//	{
//		System.out.println("Username is :"+userName1);
//		System.out.println("Crushname is :"+crushName1);
//		
//		model.addAttribute("userName",userName1);
//		model.addAttribute("crushName",crushName1);
//		
//		
//		return "result-page";
//	}
	
	
//	@RequestMapping("/process-homepage")
//	public String processHomePage(UserInfoDTO userInfoDTO,Model model)
//	{
//		System.out.println("Username is :"+userInfoDTO.getUserName());
//		System.out.println("Crushname is :"+userInfoDTO.getCrushName());
//		
//    	model.addAttribute("userInfoDto",userInfoDTO);
////		model.addAttribute("crushName",crushName1);
//		
//		
//		return "result-page";
//	}
	
	
	@RequestMapping("/process-homepage")
	public String processHomePage(@Valid @ModelAttribute("userInfo")UserInfoDTO userInfoDTO, BindingResult result)
	{
		
		
		System.out.println(userInfoDTO.isTermsAndConditions());
		
		if(result.hasErrors())
		{
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError temp:allErrors)
			{
				System.out.println(temp);
			}
			return "home-page";
		}
		
		return "result-page";
	}
	
	
}
