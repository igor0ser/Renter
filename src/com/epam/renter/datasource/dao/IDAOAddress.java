package com.epam.renter.datasource.dao;

import com.epam.renter.entities.Address;

public interface IDAOAddress {
	
	public Address read(int idAddress);

	public boolean create(Address address);
	
}
