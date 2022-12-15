package com.railways.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.railways.UserDetailsCache;
import com.railways.model.UserDetails;
import com.railways.service.EmailService;
import com.railways.service.RegistrationService;
import com.railways.utils.StoreOTP;
import com.railways.utils.UserUtility;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	UserDetailsCache userDetailsCache;

	@Autowired
	UserUtility userUtility;

	@Autowired
	public EmailService emailService;

	@PostMapping("/registration")
	public String save(String fname, String lname, String gender, String email, String password, String rpassword,
			String city, String mobile, String dob, ModelMap model) throws Exception {

		boolean errorFlag = userUtility.regValidation(fname, lname, gender, email, password, rpassword, city, mobile,
				dob, model);

		if (errorFlag) {
			return "registration";
		}

		Integer age = UserUtility.getAge(dob);

		UserDetails user = new UserDetails(fname, lname, gender, email, password, city, mobile, dob, age);

		registrationService.registerUser(user);

		model.put("userName", fname);
		model.put("email", email);

		emailService.sendOtpMessage(email);

		userDetailsCache.setUserDetails(user);

		return "otp";
	}

	@PostMapping("/otp")
	public String otpVerification(String verifyOTP, String otp, String email, String fname, ModelMap model)throws Exception {

		model.put("userName", fname);
		model.put("email", email);

		if (verifyOTP != null && verifyOTP.equals("login")) {
			
			if (userDetailsCache != null && userDetailsCache.getOTP(email) != null) {

				StoreOTP storeOTP = userDetailsCache.getOTP(email);
				Long endseconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

				if (storeOTP.getOtp().equals(otp) ) {
					
					if((endseconds - storeOTP.getMilliseconds()) <= 120) {
						model.put("userName", fname);
						userDetailsCache.removeOTP(email);
						return "welcome";
					} else {
						model.put("otpErrorMsg", "OTP Expired!!. Please generate New OTP.");
						return "otp";
					}
					

				} else {

					model.put("otpErrorMsg", "Invalid OTP, Please Try with Valid OTP.");
					return "otp";
				}

			} else {
				model.put("otpErrorMsg", "Invalid OTP, Please Try with Valid OTP.");
				return "index";
			}
		} else {
			model.put("userName", fname);
			model.put("email", email);

			emailService.sendOtpMessage(email);

			return "otp";
		}

	}

	@PostMapping("/backToHome")
	public String backToHome() {

		if (userDetailsCache != null && userDetailsCache.getUserDetails() != null) {

			return "welcom";
		}

		return "index";

	}

}
