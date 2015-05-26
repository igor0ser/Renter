package com.epam.renter.datasource;

import com.epam.renter.datasource.dao.*;

public class MySQLFactory {
	public final IDAOAddress mySQLDAOAddress = new MySQLDAOAddress();
	
	public final IDAOApplication mySQLDAOApplication = new MySQLDAOApplication();
	
	public final IDAODispatcher mySQLDAODispatcher = new MySQLDAODispatcher();
	
	public final IDAOWorker mySQLDAOWorker = new MySQLDAOWorker();
	
	public final IDAOUser mySQLDAOUser = new MySQLDAOUser();
	
	
}
