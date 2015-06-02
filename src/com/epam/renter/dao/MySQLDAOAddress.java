package com.epam.renter.dao;

import com.epam.renter.datasource.ConnectionSource;
import com.epam.renter.entities.Address;
import com.epam.renter.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDAOAddress implements IDAOAddress {
	private static String READ_BY_ID_QUERY = "SELECT * FROM addresses WHERE idUser=?;";
	private static String CREATE_QUERY = "INSERT INTO addresses (street, house, appartment, idUser) VALUES (?,?,?,?);";

	@Override
	public Address findByID(int idUser) {
		Address address = null;
		try (Connection conn = ConnectionSource.getInstance().getConnection();) {
			PreparedStatement preparedStatement = conn
					.prepareStatement(READ_BY_ID_QUERY);
			preparedStatement.setInt(1, idUser);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				address = new Address();
				address.setId(resultSet.getInt("idAddress"));
				address.setStreet(resultSet.getString("street"));
				address.setHouse(resultSet.getString("house"));
				address.setAppartment(resultSet.getString("appartment"));
				address.setUser(new User(resultSet.getInt("idUser")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public boolean create(Address address) {
		try (Connection dbConnection = ConnectionSource.getInstance()
				.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(CREATE_QUERY);
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getHouse());
			preparedStatement.setString(3, address.getAppartment());
			preparedStatement.setInt(4, address.getUser().getId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
