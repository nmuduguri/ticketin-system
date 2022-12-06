package com.railways.utils;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.railways.model.UserDetails;
import com.railways.service.LoginService;

@Component
public class UserUtility {
	
	@Autowired
	private LoginService loginServie;

	public static Integer getAge(String dob) {

		if(dob != null) {
			
			LocalDate cDate = LocalDate.now();
			Integer cYear = cDate.getYear();

			String[] dateArray = null;

			if (dob != null && dob.length() == 10) {
				dateArray = dob.split("-");
			}
			return (cYear - Integer.valueOf(dateArray[0]));
		}
		return null;
		
	}
	
	public  boolean regValidation(String fname, String lname, String gender, String email, String password, String rpassword,
			String city, String mobile, String dob, ModelMap model) {
		String errorMsg;
		boolean errorFlag = false;
		
		Integer age = UserUtility.getAge(dob);

		if (fname == null || fname.isBlank() || !validate(fname)) {
			errorMsg = "Please Enter Valid First Name :" + fname;
			model.put("fnameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (lname == null || lname.isBlank() || !validate(lname)) {
			errorMsg = "Please Enter Valid First Name :" + lname;
			model.put("lnameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (gender == null || gender.isBlank() || !validate(lname)) {
			errorMsg = "Please Select Gender ";
			model.put("lnameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (email == null || email.isBlank() || email.isEmpty() || !email.contains("@") || !email.contains(".com")) {
			errorMsg = "Please Enter Valid Email :" + email + "   Ex: example@gmail.com";
			model.put("emailErrorMsg", errorMsg);
			errorFlag = true;

		} else {

			UserDetails stu = loginServie.getUserDetails(email);

			if (stu != null) {
				errorMsg = "Email Already Registered :" + email + ", Please Try with New Email";
				model.put("emailErrorMsg", errorMsg);
				errorFlag = true;
			}
		}
		if (password == null || password.isBlank()
				|| password != null && !password.isEmpty() && (!password.contains("@") && !password.contains("$")
						&& !password.contains("&") && !password.contains("*") && !password.contains("!"))) {

			errorMsg = "Password Should Contails At Least One Specail Character And Allowed Special Characters are @$&!*";
			model.put("passwordErrorMsg", errorMsg);
			errorFlag = true;
		}

		if (rpassword == null || rpassword.isBlank() || !password.equalsIgnoreCase(rpassword)) {
			errorMsg = "Password & Re-Entered Password Should be Same";
			model.put("rpasswordErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (city == null || city.isBlank() || !validate(city)) {
			errorMsg = "Please Enter Valid City :" + city;
			model.put("cityErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (mobile == null || mobile.isBlank() || mobile.length() != 10 || (!mobile.startsWith("6")
				&& !mobile.startsWith("7") && !mobile.startsWith("8") && !mobile.startsWith("9"))) {

			errorMsg = "Please Enter Valid Moble Number :" + mobile;
			model.put("mobileErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (dob == null || dob.isBlank()) {
			age = UserUtility.getAge(dob);
			errorMsg = "Please Select Date Of Birth ";
			model.put("dobErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (age == null || age < 8 || age > 80) {
			errorMsg = "Age Should be B/w 8 To 80 :" + age;
			model.put("ageErrorMsg", errorMsg);
			errorFlag = true;
		}

		return errorFlag;
	}
	
	public  boolean ticketValidation(String fname, String lname, String gender, String doj, String age, String trainName, String tickets, String source, String distination, String amount,
			String mobile, String email,ModelMap model) {
		String errorMsg;
		boolean errorFlag = false;
		

		if (fname == null || fname.isBlank() || !validate(fname)) {
			errorMsg = "Please Enter Valid First Name :" + fname;
			model.put("fnameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (lname == null || lname.isBlank() || !validate(lname)) {
			errorMsg = "Please Enter Valid First Name :" + lname;
			model.put("lnameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (gender == null || gender.isBlank() || !validate(gender)) {
			errorMsg = "Please Select Gender ";
			model.put("genderErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (doj == null || doj.isBlank()) {
			errorMsg = "Please Select Date Of Journey ";
			model.put("dojErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (source == null || source.isBlank() || !validate(source)) {
			errorMsg = "Please Select Source ";
			model.put("trainNameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (distination == null || distination.isBlank() || !validate(distination)) {
			errorMsg = "Please Select Distination ";
			model.put("trainNameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (trainName == null || trainName.isBlank()) {
			errorMsg = "Please Select Train ";
			model.put("trainNameErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (trainName == null || trainName.isBlank() || Integer.valueOf(tickets)<=0) {
			errorMsg = "Please Enter Valid No.Of Tikets ";
			model.put("ticketsErrorMsg", errorMsg);
			errorFlag = true;
		}
		if (email == null || email.isBlank() || email.isEmpty() || !email.contains("@") || !email.contains(".com")) {
			errorMsg = "Please Enter Valid Email :" + email + "   Ex: example@gmail.com";
			model.put("emailErrorMsg", errorMsg);
			errorFlag = true;

		}
		if (mobile == null || mobile.isBlank() || mobile.length() != 10 || (!mobile.startsWith("6")
				&& !mobile.startsWith("7") && !mobile.startsWith("8") && !mobile.startsWith("9"))) {

			errorMsg = "Please Enter Valid Moble Number :" + mobile;
			model.put("mobileErrorMsg", errorMsg);
			errorFlag = true;
		}
		
		if (age == null || Integer.valueOf(age) < 14 || Integer.valueOf(age) > 80) {
			errorMsg = "Age Should be in B/w 14 To 80 :" + age;
			model.put("ageErrorMsg", errorMsg);
			errorFlag = true;
		}

		return errorFlag;
	}

	private boolean validate(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isLetter(text.charAt(i))) {
				return false;
			}
		}

		return true;
	}

}
