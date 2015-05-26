package com.epam.renter.dao;

import com.epam.renter.entities.Address;

public interface IDAOAddress {
	
	public Address readByID(int idAddress);
	
	public Address readByAddress(String street, String houseNumber, String appartmentNumber);

	public boolean create(Address address);
	
}
