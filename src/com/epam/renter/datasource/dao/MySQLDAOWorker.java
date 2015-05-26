package com.epam.renter.datasource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.renter.datasource.DataSource;
import com.epam.renter.entities.TypeOfWork;
import com.epam.renter.entities.Worker;

public class MySQLDAOWorker implements IDAOWorker {

	private static String READ_ALL_QUERY = "SELECT *  FROM workers;";
	private static String READ_BY_ID_QUERY = "SELECT *  FROM workers WHERE idWorker=?;";
	private static String READ_BY_LOGIN_QUERY = "SELECT * FROM workers WHERE login=?;";
	private static String CREATE_QUERY = "INSERT INTO workers (login, password, lastName, firstName, email, phoneNumber, typeOfWork) VALUES (?,?,?,?,?,?,?);";

	
	@Override
	public Worker read(int idWorker) {
		Worker worker = null;
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_ID_QUERY);
			preparedStatement.setInt(1, idWorker);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				worker = new Worker();
				worker.setId(resultSet.getInt("idWorker"));
				worker.setLogin(resultSet.getString("login"));
				worker.setPassword(resultSet.getString("password"));
				worker.setLastName(resultSet.getString("lastName"));
				worker.setEmail(resultSet.getString("email"));
				worker.setPhoneNumber(resultSet.getString("phoneNumber"));
				worker.setTypeOfWork(TypeOfWork.valueOf(resultSet
						.getString("typeOfWork")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return worker;
	}

	@Override
	public Worker read(String login) {
		Worker worker = null;
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_LOGIN_QUERY);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				worker = new Worker();
				worker.setId(resultSet.getInt("idWorker"));
				worker.setLogin(resultSet.getString("login"));
				worker.setPassword(resultSet.getString("password"));
				worker.setLastName(resultSet.getString("lastName"));
				worker.setEmail(resultSet.getString("email"));
				worker.setPhoneNumber(resultSet.getString("phoneNumber"));
				worker.setTypeOfWork(TypeOfWork.valueOf(resultSet
						.getString("typeOfWork")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return worker;
	}

	@Override
	public List<Worker> readAll() {
		List<Worker> list = new ArrayList<Worker>();
		try (Connection dbConnection = DataSource.getConnection();) {
		PreparedStatement preparedStatement = dbConnection
				.prepareStatement(READ_ALL_QUERY);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Worker worker = new Worker();
			worker.setId(resultSet.getInt("idWorker"));
			worker.setLogin(resultSet.getString("login"));
			worker.setPassword(resultSet.getString("password"));
			worker.setLastName(resultSet.getString("lastName"));
			worker.setFirstName(resultSet.getString("firstName"));
			worker.setEmail(resultSet.getString("email"));
			worker.setPhoneNumber(resultSet.getString("phoneNumber"));
			worker.setTypeOfWork(TypeOfWork.valueOf(resultSet
						.getString("typeOfWork")));
			list.add(worker);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}

	@Override
	public boolean create(Worker worker) {
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(CREATE_QUERY);
			preparedStatement.setString(1, worker.getLogin());
			preparedStatement.setString(2, worker.getPassword());
			preparedStatement.setString(3, worker.getLastName());
			preparedStatement.setString(4, worker.getFirstName());
			preparedStatement.setString(5, worker.getEmail());
			preparedStatement.setString(6, worker.getPhoneNumber());
			preparedStatement.setString(7, worker.getTypeOfWork().toString());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


}
