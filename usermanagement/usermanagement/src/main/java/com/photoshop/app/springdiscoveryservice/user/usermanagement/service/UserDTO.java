package com.photoshop.app.springdiscoveryservice.user.usermanagement.service;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String userId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", userId=" + userId + "]";
	}

}
