package com.epam.renter.datasource.dao;

import java.util.List;

import com.epam.renter.entities.Worker;

public interface IDAOWorker {
	public Worker read(int idWorker);
	
	public Worker read(String login);
	
	public List<Worker> readAll();

	public boolean create(Worker worker);
}
