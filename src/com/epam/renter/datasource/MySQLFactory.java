package com.epam.renter.datasource;

import com.epam.renter.dao.*;

public class MySQLFactory {
	public final IDAOAddress mySQLDAOAddress = new MySQLDAOAddress();
	
	public final IDAOApplication mySQLDAOApplication = new MySQLDAOApplication();
	
	public final IDAOAbstractUser mySQLDAODispatcher = new MySQLDAODispatcher();
	
	public final IDAOAbstractUser mySQLDAOWorker = new MySQLDAOWorker();
	
	public final IDAOAbstractUser mySQLDAOUser = new MySQLDAOUser();
	
	
}
