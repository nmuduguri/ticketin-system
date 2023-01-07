package com.railways.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railways.UserDetailsCache;
import com.railways.model.UserDetails;
import com.railways.service.EmailService;
import com.railways.service.LoginService;
import com.railways.service.UpdateProfileService;
import com.railways.utils.StoreOTP;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginServie;

	@Autowired
	UserDetailsCache userDetailsCache;

	@Autowired
	public EmailService emailService;

	@Autowired
	private UpdateProfileService updateProfileService;

	@PostMapping("/login")
	public String login(String email, String password, ModelMap model) throws Exception {

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

	@GetMapping("/forgotPassword")
	public String forgotPassword() {

		return "forgotPassword";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(String email, ModelMap model) throws Exception {

		if (email == null || email.isBlank() || email.isEmpty() || !email.contains("@") || !email.contains(".com")) {
			String errorMsg = "Please Enter Valid Email :" + email + "Ex: example@gmail.com";
			model.put("forgotPasswordErrorMsg", errorMsg);
			return "forgotPassword";

		} else {
			UserDetails user = loginServie.getUserDetails(email);

			if (user != null && user.getEmail().equalsIgnoreCase(email)) {

				model.put("userName", user.getFname());
				model.put("email", email);

				emailService.sendOtpMessage(email);
				userDetailsCache.setUserDetails(user);

				return "passwordOTP";
			} else {
				model.put("forgotPasswordErrorMsg", "Given Email Is Not Registered.");
				return "forgotPassword";
			}
		}
	}

	@PostMapping("/changePwdOTP")
	public String changePwdOTP(String verifyOTP, String fname, String email, String password, String rpassword,
			ModelMap model) throws Exception {

		model.put("userName", fname);
		model.put("email", email);

		if (password == null || password.isBlank()
				|| password != null && !password.isEmpty() && (!password.contains("@") && !password.contains("$")
						&& !password.contains("&") && !password.contains("*") && !password.contains("!"))) {

			String errorMsg = "Password Should Contails At Least One Specail Character And Allowed Special Characters are @$&!*";
			model.put("passwordErrorMsg", errorMsg);

			return "changePwdOTP";
		} else {

			UserDetails user = new UserDetails(null, null, null, email, password, null, null, null, null);

			updateProfileService.updateUserDetails(user);

			model.put("successMsg", "Password Changed Successfully");
			return "success";
		}

	}

	@PostMapping("/passwordOTP")
	public String otpVerification(String verifyOTP, String otp, String email, String fname, ModelMap model)
			throws Exception {

		model.put("userName", fname);
		model.put("email", email);

		if (verifyOTP != null && verifyOTP.equals("passwordOTP")) {

			StoreOTP storeOTP = userDetailsCache.getOTP(email);
			Long endseconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

			if (storeOTP.getOtp().equals(otp)) {

				if ((endseconds - storeOTP.getMilliseconds()) <= 120) {
					model.put("userName", fname);
					userDetailsCache.removeOTP(email);
					return "changePwdOTP";
				} else {
					model.put("otpErrorMsg", "OTP Expired!!. Please generate New OTP.");
					return "passwordOTP";
				}

			} else {

				model.put("otpErrorMsg", "Invalid OTP, Please Try with Valid OTP.");
				return "passwordOTP";
			}

		} else {
			model.put("userName", fname);
			model.put("email", email);

			emailService.sendOtpMessage(email);

			return "passwordOTP";
		}

	}
	
	

}
