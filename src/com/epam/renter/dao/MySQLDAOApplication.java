package com.epam.renter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.epam.renter.datasource.ConnectionSource;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;
import com.epam.renter.entities.TypeOfWork;

public class MySQLDAOApplication implements IDAOApplication{

	private static String READ_BY_USER_ID_QUERY = "SELECT * FROM applications WHERE idUser=?;";
	private static String READ_BY_STATUS_QUERY = "SELECT idApplication, idUser, about, status, typeOfWork, creationDate, desirableDate, completeDate, idWorker FROM applications WHERE STATUS=?;";
	private static String READ_ALL_QUERY = "SELECT idApplication, idUser, about, status, typeOfWork, creationDate, desirableDate, completeDate, idWorker FROM applications";
	private static String CREATE_QUERY = "INSERT INTO applications (idUser, about, status, typeOfWork, creation, desirable, start, end) VALUES (?,?,?,?,?,?,?,?);";

	
	public List<Application> readByUserID(int userID){
		List<Application> list = new ArrayList<>();
		try (Connection conn = ConnectionSource.getInstance().getConnection();) {
			PreparedStatement preparedStatement = conn
					.prepareStatement(READ_BY_USER_ID_QUERY);
			preparedStatement.setInt(1, userID);
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
				application.setCreation(resultSet
						.getTimestamp("creation"));
				application.setDesirable(resultSet
						.getTimestamp("desirable"));
				application.setStart(resultSet
						.getTimestamp("start"));
				application.setEnd(resultSet
						.getTimestamp("end"));
				list.add(application);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


	@Override
	public List<Application> readByStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean create(Application application) {
		try (Connection dbConnection = ConnectionSource.getInstance().getConnection();) {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(CREATE_QUERY);
			preparedStatement.setInt(1, application.getUser().getId());
			preparedStatement.setString(2, application.getAbout());
			preparedStatement.setString(3, application.getStatus().toString());
			preparedStatement.setString(4, application.getTypeOfWork()
					.toString());
			preparedStatement.setTimestamp(5, new Timestamp(application
					.getCreation().getTime()));
			preparedStatement.setTimestamp(6, new Timestamp(application
					.getDesirable().getTime()));
			
			Timestamp start = (application.getStart() == null) ? null : new Timestamp(application
					.getStart().getTime());
			Timestamp end = (application.getEnd() == null) ? null : new Timestamp(application
					.getEnd().getTime());
			
			preparedStatement.setTimestamp(7, start);
			preparedStatement.setTimestamp(8, end);
			

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	}


	


