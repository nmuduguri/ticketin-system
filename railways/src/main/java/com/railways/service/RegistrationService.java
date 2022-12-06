package com.railways.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.model.UserDetails;
import com.railways.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public void registerUser(UserDetails userDetails) {
		
		registrationRepository.save(userDetails);
	}
}
