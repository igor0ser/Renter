package com.epam.renter.service;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.AbstractUser;

public class ServiceAbstractUser {
	
	public static AbstractUser getUser(String login) {
		AbstractUser abstractUser = DAOFactory.mySQLFactory.mySQLDAOUser
				.findByLogin(login);
		if (abstractUser == null) {
			abstractUser = DAOFactory.mySQLFactory.mySQLDAODispatcher
					.findByLogin(login);
		}
		if (abstractUser == null) {
			abstractUser = DAOFactory.mySQLFactory.mySQLDAOWorker
					.findByLogin(login);
		}
		return abstractUser;
	}

	public static boolean isLoginFree(String login) {
		return (getUser(login) == null);
	}
}
