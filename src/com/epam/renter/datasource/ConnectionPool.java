package com.epam.renter.datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


public class ConnectionPool {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/renter";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static ConnectionPool instance = new ConnectionPool();
	private static LinkedList<Connection> connectionPool = new LinkedList<Connection>();

	private ConnectionPool() {
				try {
			Class.forName(DB_DRIVER);
		} catch (Exception ex) {
			System.err.println("Class not found");
			ex.printStackTrace();
		}
	}

    public Connection createConnection() {
        Connection conn = null;
        try {
              conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception ex) {
            System.err.println("Cannot connect to database server");
            ex.printStackTrace();
        }
        return conn;
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

   public Connection getConnection() {
        if (!connectionPool.isEmpty()) {
            return connectionPool.pop();
        } else {
            return createConnection();
        }
    }

    public void freeConnection(Connection conn) {
        connectionPool.push(conn);
    }

    public static void closeAllConnections() throws SQLException {
        for (Connection connection : connectionPool) {
            connection.close();
        }
        connectionPool.clear();
    }

    public static int getNumberOfFreeConnections() {
        if (connectionPool != null) {
            return connectionPool.size();
        } else {
            return 0;
        }
    }
	
	
}
