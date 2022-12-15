package com.railways;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.railways.model.UserDetails;
import com.railways.utils.StoreOTP;

@Component
public class UserDetailsCache {

	private UserDetails userDetails;
	
	public static Map<String, StoreOTP> otpMap = new HashMap<>();

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public void setOTP(String email, StoreOTP otp) {
		otpMap.put(email, otp);
	}

	public StoreOTP getOTP(String email) {
		return otpMap.get(email);
	}
	
	public StoreOTP removeOTP(String email) {
		return otpMap.remove(email);
	}
	
}


// @Component
// @Bean
// @Controller == @Component + Some Editional capcity ()
// @Service 	== @Component + Some Business functionality capacity()
// @Reposiotry	== @Component + it will convert database exp into java exp
// @RestController== @Component + @ReponseBody + Some Editional capcity ()



