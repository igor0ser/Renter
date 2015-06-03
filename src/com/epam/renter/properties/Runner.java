package com.epam.renter.properties;

import java.util.List;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;

public class Runner {
public static void main(String[] args) {
	System.out.println(Message.getInstance().getProperty(Message.WRONG_LOGIN));
	
	Status status = Status.CREATED;
	System.out.println(status.toString());
	
	List<Application> list = DAOFactory.mySQLFactory.mySQLDAOApplication
			.readByStatus(Status.CREATED);
	System.out.println(list.size());
}
}
