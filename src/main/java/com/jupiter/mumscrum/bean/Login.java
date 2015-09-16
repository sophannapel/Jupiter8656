package com.jupiter.mumscrum.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	
	@NotEmpty(message = "Enter your username")
	private String username;
	@NotEmpty(message = "Enter your password")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
