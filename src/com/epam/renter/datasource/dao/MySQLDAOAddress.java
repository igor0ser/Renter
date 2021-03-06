package com.epam.renter.datasource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.renter.datasource.DataSource;
import com.epam.renter.entities.Address;

public class MySQLDAOAddress implements IDAOAddress {
	private static String READ_BY_ID_QUERY = "SELECT idAddress, street, house, appartment FROM addresses WHERE idAddress=?;";
	private static String READ_BY_ADDRESS_QUERY = "SELECT idAddress, street, house, appartment FROM addresses WHERE (street=? AND house=? AND appartment=?);";
	private static String CREATE_QUERY = "INSERT INTO addresses (street, house, appartment) VALUES (?,?,?);";

	public Address readByID(int idAddress) {
		Address address = null;
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_ID_QUERY);
			preparedStatement.setInt(1, idAddress);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				address = new Address(resultSet.getInt("idAddress"),
						resultSet.getString("street"),
						resultSet.getString("house"),
						resultSet.getString("appartment"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public Address readByAddress(String street, String houseNumber,
			String appartmentNumber) {
		Address address = null;
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_ADDRESS_QUERY);
			preparedStatement.setString(1, street);
			preparedStatement.setString(2, houseNumber);
			preparedStatement.setString(3, appartmentNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				address = new Address(resultSet.getInt("idAddress"),
						resultSet.getString("street"),
						resultSet.getString("house"),
						resultSet.getString("appartment"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	public boolean create(Address address) {
		try (Connection dbConnection = DataSource.getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(CREATE_QUERY);
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getHouse());
			preparedStatement.setString(3, address.getAppartment());
			return !preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
