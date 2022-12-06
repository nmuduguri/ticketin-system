package com.railways.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.model.UserDetails;
import com.railways.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public UserDetails getUserDetails(String email) {

		return loginRepository.getUserDetails(email);
	}

}
