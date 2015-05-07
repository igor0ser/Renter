package com.epam.utilities.users;

public class Address {
	
public Address(String street, String houseNumber, String appartmentNumber) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.appartmentNumber = appartmentNumber;
	}

private String street;
private String houseNumber;
private String appartmentNumber;

public String getStreet() {
	return street;
}

public String getHouseNumber() {
	return houseNumber;
}

public String getAppartmentNumber() {
		return appartmentNumber;
	}
}
