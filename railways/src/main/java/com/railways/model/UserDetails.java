package com.railways.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue
	private Integer id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String gender;
	private String city;
	private String mobile;
	private String dob;
	private Integer age;
	
	public UserDetails() {
		super();
	}

	public UserDetails(String fname, String lname, String gender, String email, String password, String city,
			String mobile, String dob, Integer age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender=gender;
		this.email = email;
		this.password = password;
		this.city = city;
		this.mobile = mobile;
		this.dob = dob;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", gender=" + gender + ", city=" + city + ", mobile=" + mobile + ", dob=" + dob + ", age="
				+ age + "]";
	}
	
}
