package com.epam.renter.dao;

import java.util.List;

import com.epam.renter.entities.Dispatcher;

public interface IDAODispatcher {
	public Dispatcher read(int idDispatcer);
	
	public Dispatcher read(String login);
	
	public List<Dispatcher> readAll();

	public boolean create(Dispatcher dispatcher);
}
