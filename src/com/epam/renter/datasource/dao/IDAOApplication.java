package com.epam.renter.datasource.dao;

import java.util.List;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;

public interface IDAOApplication {

	public List<Application> read(int userId);

	public List<Application> read(Status status);

	public List<Application> readAll();

	public boolean create(Application application);

}
