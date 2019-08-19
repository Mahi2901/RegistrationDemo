package com.web.registrationdemo.controller;


import java.util.HashSet;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.web.registrationdemo.model.RegisterModel;
import com.web.registrationdemo.model.RoleModel;
import com.web.registrationdemo.repository.RoleRepo;
import com.web.registrationdemo.service.RegisterService;

@Controller
public class RegisterController 
{
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	RoleRepo roleRepo;
		
	@RequestMapping("/Registration")
	public String Registration() 
	{
		return "Registration";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute RegisterModel register, HttpSession session, HttpServletRequest request,
			ModelMap modelMap) 
	{
		String captcha = session.getAttribute("captcha_security").toString();
		String verifyCaptcha = request.getParameter("captcha");
		if (captcha.equals(verifyCaptcha)) {
			
				
		RoleModel r = roleRepo.findById((long) 2).orElse(null);
		
		Set<RoleModel> roles = new HashSet<RoleModel>();
		roles.add(r);
		
		register.setRoles(roles);
		register.setResetToken(UUID.randomUUID().toString());
		register.setPassword(passwordEncoder.encode(register.getPassword()));
		
		
        
		registerService.save(register);
		} else {
			modelMap.put("error", "Captcha Invalid");
			return "Registration";
		}
		
		return "redirect:/login";
	}
	

}
