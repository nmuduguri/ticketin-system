package com.railways.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.railways.model.UserDetails;

@Repository
public interface LoginRepository extends JpaRepository<UserDetails, Integer> {
	
	@Query("SELECT u FROM UserDetails u WHERE u.email =:email")
	public UserDetails getUserDetails(String email);

}
