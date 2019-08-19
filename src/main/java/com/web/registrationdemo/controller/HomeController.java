package com.web.registrationdemo.controller;

import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.web.registrationdemo.model.RegisterModel;
import com.web.registrationdemo.model.StateModel;
import com.web.registrationdemo.repository.RegisterRepo;
import com.web.registrationdemo.repository.Repostate;
import com.web.registrationdemo.service.RegisterService;

@Controller
public class HomeController 
{
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	Repostate srepo;
	
	@Autowired
	RegisterRepo registerRepo;
	
	@RequestMapping(value= {"","/","/index"})
	public String page() 
	{
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() 
	{
		return "login";
	}
	@RequestMapping("/forgotpass")
	public String forgotpass() 
	{
		return "Forgot-pass";
	}
	
	@RequestMapping("/Reset-Password")
	public String resetPassword() 
	{
		return "/Reset-Password";
	}
	
	@RequestMapping("/state")
	@ResponseBody
	public List<StateModel> State() {

		return srepo.findAll();
	}
	
	
	@RequestMapping("/resetAction")
	public String resetPassword(HttpServletRequest request,HttpServletResponse response) {
		   String uname = request.getParameter("uname");
		   
		   System.out.println(uname);
		   
		  
			   RegisterModel users = registerRepo.findByEmail(uname);
			   if(users!=null) {
				   MimeMessage message = sender.createMimeMessage();
				   MimeMessageHelper helper = new MimeMessageHelper(message);
				   try {
						helper.setTo(users.getEmail());
						helper.setText("Your Password Reset Link http://localhost:8080/Reset-Password?token="+users.getResetToken());
						helper.setSubject("Mail For Reset Password");
					} catch (MessagingException e) {
						e.printStackTrace();
						return "Error while sending mail ..";
					}
					sender.send(message);
									   
				   return "redirect:/index";
	  
			   }
			   else 
			   {
				
				   return "redirect:/login";
			   }
		   
	}
	
	@RequestMapping(value = "/Reset-Password", method = RequestMethod.GET)
	public String getResetPassword(@RequestParam("token") String resetToken,Model m) 
	{
		
			RegisterModel user = registerRepo.findByResetToken(resetToken);
			if(user!=null) {
			
			m.addAttribute("email", user.getEmail());
			return "Reset-Password";
			}else {
				
				   return "redirect:/403";
			   }
		
		
	}
	
	@RequestMapping(value = "/Reset-Password", method = RequestMethod.POST)
	public String gsetResetPassword(@RequestParam("email") String email,@RequestParam("password") String password,Model m) 
	{
		
			RegisterModel user = registerRepo.findByEmail(email);
			user.setPassword(passwordEncoder.encode(password));
			user.setResetToken(UUID.randomUUID().toString());
			registerService.save(user);
			m.addAttribute("message", "Password succesfully updated");
			return "redirect:/index";
		}
	
	
	
}
