package com.railways;

import org.springframework.stereotype.Component;

import com.railways.model.UserDetails;

@Component
public class UserDetailsCache {

	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
