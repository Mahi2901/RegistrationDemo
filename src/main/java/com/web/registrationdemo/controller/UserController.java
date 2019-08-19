package com.web.registrationdemo.controller;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user")
public class UserController 
{
	
	@RequestMapping(value= {"","/","/index"})
	public String name() 
	{
		return "user/index";
	}
	
	@RequestMapping("/User")
	public String user() 
	{
		return "User";
	}
}
