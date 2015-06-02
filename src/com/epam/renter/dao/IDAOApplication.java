package com.epam.renter.dao;

import java.util.List;

import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;

public interface IDAOApplication {

	public List<Application> readByUserID(int userID);
	
	public List<Application> readByStatus(Status status);
	
	public boolean create(Application application);
	
}
