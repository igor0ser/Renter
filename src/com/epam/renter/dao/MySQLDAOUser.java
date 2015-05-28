package com.epam.renter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.epam.renter.datasource.ConnectionPool;
import com.epam.renter.entities.AbstractUser;
import com.epam.renter.entities.User;


public class MySQLDAOUser implements IDAOAbstractUser {

	private static String READ_ALL_QUERY = "SELECT *  FROM users;";
	private static String READ_BY_ID_QUERY = "SELECT *  FROM users WHERE idUser=?;";
	private static String READ_BY_LOGIN_QUERY = "SELECT * FROM users WHERE login=?;";
	private static String CREATE_QUERY = "INSERT INTO users (login, password, lastName, firstName, email, phoneNumber, idAddress) VALUES (?,?,?,?,?,?,?);";

	@Override
	public User findByID(int idUser) {
		User user = null;
		try (Connection dbConnection = ConnectionPool.getInstance().getConnection();) {
			
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_ID_QUERY);
			preparedStatement.setInt(1, idUser);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("idUser"));
				user.setLogin(resultSet.getString("login"));
				user.setPassword(resultSet.getString("password"));
				user.setLastName(resultSet.getString("lastName"));
				user.setEmail(resultSet.getString("email"));
				user.setPhoneNumber(resultSet.getString("phoneNumber"));
				user.getAddress().setId(resultSet.getInt("idAddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findByLogin(String login) {
		User user = null;
		try {
			InitialContext initContext= new InitialContext();
			
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/renterdb");
			Connection dbConnection = ds.getConnection();
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_LOGIN_QUERY);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("idUser"));
				user.setLogin(resultSet.getString("login"));
				user.setPassword(resultSet.getString("password"));
				user.setLastName(resultSet.getString("lastName"));
				user.setEmail(resultSet.getString("email"));
				user.setPhoneNumber(resultSet.getString("phoneNumber"));
				user.getAddress().setId(resultSet.getInt("idAddress"));
			}
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<AbstractUser> readAll() {
		List<AbstractUser> list = new ArrayList<AbstractUser>();
		try (Connection dbConnection = ConnectionPool.getInstance().getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_ALL_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("idUser"));
				user.setLogin(resultSet.getString("login"));
				user.setPassword(resultSet.getString("password"));
				user.setLastName(resultSet.getString("lastName"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setEmail(resultSet.getString("email"));
				user.setPhoneNumber(resultSet.getString("phoneNumber"));
				user.getAddress().setId(resultSet.getInt("idAddress"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean create(AbstractUser abstractUser) {
	
		
		//Connection dbConnection = ConnectionPool.getInstance().getConnection()
		try {
			InitialContext initContext= new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/renterdb");
			Connection dbConnection = ds.getConnection();
					User user = (User) abstractUser;
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(CREATE_QUERY);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPhoneNumber());
			preparedStatement.setInt(7,  user.getAddress().getId());
			preparedStatement.execute();
			return true;
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
