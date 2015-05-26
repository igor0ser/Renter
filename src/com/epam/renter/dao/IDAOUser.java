package com.epam.renter.dao;

import java.util.List;

import com.epam.renter.entities.User;

public interface IDAOUser {
	public User read(int idUser);
	
	public User read(String login);
	
	public List<User> readAll();

	public boolean create(User user);
}
