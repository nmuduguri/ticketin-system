package com.railways.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railways.service.EmailService;

@Controller
public class EmailController {

	@Autowired
	public EmailService emailService;

	@GetMapping("/generateOtp")
	@ResponseBody
	public String generateOTP(String otp, String email, String fname, ModelMap model) throws MessagingException {

		model.put("userName", fname);
		model.put("email", email);

		emailService.sendOtpMessage(email);

		return "otp";
	}

}
