package com.railways.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.UserDetailsCache;
import com.railways.model.UserDetails;
import com.railways.repository.LoginRepository;
import com.railways.utils.UserUtility;

@Service
public class UpdateProfileService {

	@Autowired
	private LoginService loginServie;

	@Autowired
	UserDetailsCache userDetailsCache;

	@Autowired
	private LoginRepository loginRepository;

	public void updateUserDetails(UserDetails user) {

		UserDetails dbUserDetails = loginServie.getUserDetails(userDetailsCache.getUserDetails().getEmail());

		Integer age = null;

		if (user.getFname() != null && !user.getFname().isBlank()) {
			dbUserDetails.setFname(user.getFname());
		}
		if (user.getLname() != null && !user.getLname().isBlank()) {
			dbUserDetails.setLname(user.getLname());
		}
		if (user.getGender() != null && !user.getGender().isBlank()) {
			dbUserDetails.setGender(user.getGender());
		}
		if (user.getDob() != null && !user.getDob().isBlank()) {
			dbUserDetails.setDob(user.getDob());
			age = UserUtility.getAge(user.getDob());
			dbUserDetails.setAge(age);
		}
		if (user.getEmail() != null && !user.getEmail().isBlank()) {
			dbUserDetails.setEmail(user.getEmail());
		}
		if (user.getPassword() != null && !user.getPassword().isBlank()) {
			dbUserDetails.setPassword(user.getPassword());
		}
		if (user.getCity() != null && !user.getCity().isBlank()) {
			dbUserDetails.setCity(user.getCity());
		}
		if (user.getMobile() != null && !user.getMobile().isBlank()) {
			dbUserDetails.setMobile(user.getMobile());
		}

		userDetailsCache.setUserDetails(dbUserDetails);

		loginRepository.save(dbUserDetails);

	}
}
