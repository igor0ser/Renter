package com.epam.renter.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionSource {

	private InitialContext initContext;
	private DataSource ds;
	private static ConnectionSource instance = new ConnectionSource();

	private ConnectionSource() {
		try {
			initContext = new InitialContext();
			ds = (DataSource) initContext.lookup("java:comp/env/jdbc/renterdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public static ConnectionSource getInstance() {
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
