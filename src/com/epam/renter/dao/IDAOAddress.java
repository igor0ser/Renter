package com.epam.renter.dao;

import com.epam.renter.entities.Address;

public interface IDAOAddress {
	
	public Address findByID(int id);

	public boolean create(Address address);
}
