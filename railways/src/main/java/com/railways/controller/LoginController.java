package com.railways.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.railways.UserDetailsCache;
import com.railways.model.UserDetails;
import com.railways.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginServie;
	
	@Autowired
	UserDetailsCache userDetailsCache;
	
	

	@PostMapping("/login")
	public String login(String email, String password, ModelMap model) {
		
		System.out.println("email is :"+email);
		System.out.println("password is :"+password);
		
		UserDetails user = loginServie.getUserDetails(email);
		
		System.out.println("user details :" + user);
		
		if (user != null && user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
			
			model.put("userName", user.getFname() +" "+ user.getLname());
			
			userDetailsCache.setUserDetails(user);
			
			return "welcome";
		} else {
			
			model.put("loginErrorMsg", "Please Try With Valid UserName & Password");
			
			return "login";
		}
		
		
	}
}
