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


// @Component
// @Bean
// @Controller == @Component + Some Editional capcity ()
// @Service 	== @Component + Some Business functionality capacity()
// @Reposiotry	== @Component + it will convert database exp into java exp
// @RestController== @Component + @ReponseBody + Some Editional capcity ()



