package com.epam.utilities.users;

public class User {
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	private String login;
	private String password;
	private String name;
	private String phoneNumber;

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
