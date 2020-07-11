package com.photoshop.app.springdiscoveryservice.user.usermanagement.shared;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestModel {

	@NotNull(message = "Email cannot be null")
	@Size(min = 2, message = "Email should a valid ")
	@Email
	private String email;

	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, max = 20, message = "First Name should a valid length between 2 to 20")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	@Size(min = 2, max = 20, message = "Last Name should a valid length between 2 to 20")
	private String lastName;

	@NotNull(message = "Password cannot be null")
	@Size(min = 2, max = 20, message = "Choose a password length between 2 to 20")
	private String password;

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

	@Override
	public String toString() {
		return "UserRequestModel [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}

}
