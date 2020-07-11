package com.photoshop.app.springdiscoveryservice.user.usermanagement.shared;

public class UserResponseModel {

	private String email;
	private String firstName;
	private String lastName;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserResponseModel [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", userId="
				+ userId + "]";
	}

}
