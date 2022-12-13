package com.railways.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.railways.UserDetailsCache;
import com.railways.model.UserDetails;
import com.railways.service.RegistrationService;
import com.railways.utils.UserUtility;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	UserDetailsCache userDetailsCache;

	@Autowired
	UserUtility userUtility;

	@PostMapping("/registration")
	public String save(String fname, String lname, String gender, String email, String password, String rpassword,
			String city, String mobile, String dob, ModelMap model) {

		boolean errorFlag = userUtility.regValidation(fname, lname, gender, email, password, rpassword, city, mobile,
				dob, model);

		if (errorFlag) {
			return "registration";
		}

		Integer age = UserUtility.getAge(dob);

		UserDetails user = new UserDetails(fname, lname, gender, email, password, city, mobile, dob, age);

		registrationService.registerUser(user);

		model.put("userName", fname);

		userDetailsCache.setUserDetails(user);

		return "welcome";
	}
	
	@PostMapping("/backToHome")
	public String backToHome() {
		
		if(userDetailsCache != null && userDetailsCache.getUserDetails() != null) {
			
			return "welcom";
		}
		
		return "index";
		
	}

}
