package com.railways.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.railways.UserDetailsCache;
import com.railways.model.UserDetails;
import com.railways.service.UpdateProfileService;

@Controller
public class ProfileController {

	@Autowired
	private UpdateProfileService updateProfileService;

	@Autowired
	UserDetailsCache userDetailsCache;

	@PostMapping("/profile")
	public void profileDetaile(ModelMap model) {

		System.out.println("This is ");

		if (userDetailsCache.getUserDetails() != null) {
			UserDetails user = userDetailsCache.getUserDetails();
			model.put("fname", user.getFname());
			model.put("lname", user.getLname());
			model.put("gender", user.getGender());
			model.put("dob", user.getDob());
			model.put("email", user.getEmail());
			model.put("city", user.getCity());
			model.put("mobile", user.getMobile());

		}

	}

	@PostMapping("/update")
	public String updateProfile() {
		return "update_profile";
	}

	@PostMapping("/updateUserDetails")
	public String updateProfile(String fname, String lname, String gender, String email, String city, String mobile,
			String dob, ModelMap model) {

		if (fname == null && lname == null && gender == null && email == null && city == null && mobile == null
				&& dob == null) {
			model.put("commonErrorMsg", "Atleast Update One Field");
			return "error";
		}
		
		
		UserDetails user = new UserDetails(fname, lname, gender, email, null, city, mobile, dob, null);

		updateProfileService.updateUserDetails(user);

		model.put("successMsg", "User Details Updated Successfully");

		return "success";
	}
}
