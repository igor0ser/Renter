package com.epam.renter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.epam.renter.datasource.ConnectionPool;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;
import com.epam.renter.entities.TypeOfWork;

public class MySQLDAOApplication implements IDAOApplication {
	private static String READ_BY_USER_ID_QUERY = "SELECT idApplication, idUser, about, status, typeOfWork, creationDate, desirableDate, completeDate, idWorker FROM applications WHERE idUser=?;";
	private static String READ_BY_STATUS_QUERY = "SELECT idApplication, idUser, about, status, typeOfWork, creationDate, desirableDate, completeDate, idWorker FROM applications WHERE STATUS=?;";
	private static String READ_ALL_QUERY = "SELECT idApplication, idUser, about, status, typeOfWork, creationDate, desirableDate, completeDate, idWorker FROM applications";
	private static String CREATE_QUERY = "INSERT INTO applications (idUser, about, status, typeOfWork, creationDate, desirableDate, completeDate, idWorker) VALUES (?,?,?,?,?,?,?,?);";

	@Override
	public List<Application> read(int userId) {
		List<Application> applicationList = new ArrayList<>();
		try (Connection dbConnection = ConnectionPool.getInstance().getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_USER_ID_QUERY);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Application application = new Application();
				application.setId(resultSet.getInt("idApplication"));
				application.getUser().setId(resultSet.getInt("idUser"));
				application.setAbout(resultSet.getString("about"));
				application.setStatus(Status.valueOf(resultSet
						.getString("status")));
				application.setTypeOfWork(TypeOfWork.valueOf(resultSet
						.getString("typeOfWork")));
				application.setCreationDate(resultSet
						.getTimestamp("creationDate"));
				application.setDesirableDate(resultSet
						.getTimestamp("desirableDate"));
				application.setCompleteDate(resultSet
						.getTimestamp("completeDate"));
				application.getWorker().setId(resultSet.getInt("idWorker"));
				applicationList.add(application);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicationList;
	}

	@Override
	public List<Application> read(Status status) {
		List<Application> applicationList = new ArrayList<>();
		try (Connection dbConnection = ConnectionPool.getInstance().getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_BY_STATUS_QUERY);
			preparedStatement.setString(1, status.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Application application = new Application();
				application.setId(resultSet.getInt("idApplication"));
				application.getUser().setId(resultSet.getInt("idUser"));
				application.setAbout(resultSet.getString("about"));
				application.setStatus(Status.valueOf(resultSet
						.getString("status")));
				application.setTypeOfWork(TypeOfWork.valueOf(resultSet
						.getString("typeOfWork")));
				application.setCreationDate(resultSet
						.getTimestamp("creationDate"));
				application.setDesirableDate(resultSet
						.getTimestamp("desirableDate"));
				application.setCompleteDate(resultSet
						.getTimestamp("completeDate"));
				application.getWorker().setId(resultSet.getInt("idWorker"));
				applicationList.add(application);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicationList;
	}

	@Override
	public List<Application> readAll() {
		List<Application> applicationList = new ArrayList<>();
		try (Connection dbConnection = ConnectionPool.getInstance().getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(READ_ALL_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Application application = new Application();
				application.setId(resultSet.getInt("idApplication"));
				application.getUser().setId(resultSet.getInt("idUser"));
				application.setAbout(resultSet.getString("about"));
				application.setStatus(Status.valueOf(resultSet
						.getString("status")));
				application.setTypeOfWork(TypeOfWork.valueOf(resultSet
						.getString("typeOfWork")));
				application.setCreationDate(resultSet
						.getTimestamp("creationDate"));
				application.setDesirableDate(resultSet
						.getTimestamp("desirableDate"));
				application.setCompleteDate(resultSet
						.getTimestamp("completeDate"));
				application.getWorker().setId(resultSet.getInt("idWorker"));
				applicationList.add(application);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicationList;
	}

	@Override
	public boolean create(Application application) {
		try (Connection dbConnection = ConnectionPool.getInstance().getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(CREATE_QUERY);
			preparedStatement.setInt(1, application.getUser().getId());
			preparedStatement.setString(2, application.getAbout());
			preparedStatement.setString(3, application.getStatus().toString());
			preparedStatement.setString(4, application.getTypeOfWork()
					.toString());
			preparedStatement.setTimestamp(5, new Timestamp(application
					.getCreationDate().getTime()));
			preparedStatement.setTimestamp(6, new Timestamp(application
					.getDesirableDate().getTime()));
			if (application.getCompleteDate() == null) {
				preparedStatement.setTimestamp(7, null);
			} else {
				preparedStatement.setTimestamp(7, new Timestamp(application
						.getCompleteDate().getTime()));
			}
			if (application.getWorker() == null) {
				preparedStatement.setString(8, null);
			} else {
				preparedStatement.setInt(8, application.getUser().getId());
			}

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
