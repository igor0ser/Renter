package com.epam.renter.dao;

import java.util.List;

import com.epam.renter.entities.AbstractUser;

public interface IDAOAbstractUser {
	public AbstractUser findByID(int idUser);
	
	public AbstractUser findByLogin(String login);
	
	public List<AbstractUser> readAll();

	public boolean create(AbstractUser user);
}
