package com.epam.utilities.users;

public class Renter extends User {
	
	public Renter(String login, String password) {
		super(login, password);
	}

	private Address address;
}
