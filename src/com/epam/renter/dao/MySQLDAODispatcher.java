package com.epam.renter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.renter.datasource.DataSource;
import com.epam.renter.entities.Dispatcher;

public class MySQLDAODispatcher implements IDAODispatcher {
	private static String READ_ALL_QUERY = "SELECT *  FROM dispatchers;";
	private static String READ_BY_ID_QUERY = "SELECT *  FROM dispatchers WHERE idDispatcher=?;";
	private static String READ_BY_LOGIN_QUERY = "SELECT * FROM dispatchers WHERE login=?;";
	private static String CREATE_QUERY = "INSERT INTO dispatchers (login, password, lastName, firstName, email, phoneNumber) VALUES (?,?,?,?,?,?);";

	@Override
	public Dispatcher read(int idDispatcher) {
		Dispatcher dispatcher = null;
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_ID_QUERY);
			preparedStatement.setInt(1, idDispatcher);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				dispatcher = new Dispatcher();
				dispatcher.setId(resultSet.getInt("idDispatcher"));
				dispatcher.setLogin(resultSet.getString("login"));
				dispatcher.setPassword(resultSet.getString("password"));
				dispatcher.setLastName(resultSet.getString("lastName"));
				dispatcher.setEmail(resultSet.getString("email"));
				dispatcher.setPhoneNumber(resultSet.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dispatcher;
	}

	@Override
	public Dispatcher read(String login) {
		Dispatcher dispatcher = null;
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_LOGIN_QUERY);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				dispatcher = new Dispatcher();
				dispatcher.setId(resultSet.getInt("idDispatcher"));
				dispatcher.setLogin(resultSet.getString("login"));
				dispatcher.setPassword(resultSet.getString("password"));
				dispatcher.setLastName(resultSet.getString("lastName"));
				dispatcher.setFirstName(resultSet.getString("firstName"));
				dispatcher.setEmail(resultSet.getString("email"));
				dispatcher.setPhoneNumber(resultSet.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dispatcher;
	}
	
	@Override
	public List<Dispatcher> readAll() {
		List<Dispatcher> list = new ArrayList<Dispatcher>();
		try (Connection dbConnection = DataSource.getConnection();) {
		PreparedStatement preparedStatement = dbConnection
				.prepareStatement(READ_ALL_QUERY);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Dispatcher dispatcher = new Dispatcher();
			dispatcher.setId(resultSet.getInt("idDispatcher"));
			dispatcher.setLogin(resultSet.getString("login"));
			dispatcher.setPassword(resultSet.getString("password"));
			dispatcher.setLastName(resultSet.getString("lastName"));
			dispatcher.setFirstName(resultSet.getString("firstName"));
			dispatcher.setEmail(resultSet.getString("email"));
			dispatcher.setPhoneNumber(resultSet.getString("phoneNumber"));
			list.add(dispatcher);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
		
	}
	@Override
	public boolean create(Dispatcher dispatcher) {
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(CREATE_QUERY);
			preparedStatement.setString(1, dispatcher.getLogin());
			preparedStatement.setString(2, dispatcher.getPassword());
			preparedStatement.setString(3, dispatcher.getLastName());
			preparedStatement.setString(4, dispatcher.getFirstName());
			preparedStatement.setString(5, dispatcher.getEmail());
			preparedStatement.setString(6, dispatcher.getPhoneNumber());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
		

}
