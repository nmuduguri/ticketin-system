package com.railways.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.railways.UserDetailsCache;
import com.railways.model.UserDetails;
import com.railways.service.EmailService;
import com.railways.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginServie;
	
	@Autowired
	UserDetailsCache userDetailsCache;
	
	@Autowired
	public EmailService emailService;

	@PostMapping("/login")
	public String login(String email, String password, ModelMap model)throws Exception {
		
		;
		
		UserDetails user = loginServie.getUserDetails(email);
		
		
		if (user != null && user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
			
			model.put("userName", user.getFname());
			model.put("email", email);
			
			emailService.sendOtpMessage(email);
			userDetailsCache.setUserDetails(user);
			
			return "otp";
		} else {
			
			model.put("loginErrorMsg", "Please Try With Valid UserName & Password");
			
			return "login";
		}
		
		
	}
}
