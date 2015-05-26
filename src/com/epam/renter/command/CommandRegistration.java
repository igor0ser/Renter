package com.epam.renter.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Address;
import com.epam.renter.entities.User;

public class CommandRegistration implements ICommand {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String REPEAT_PASSWORD = "repeat_password";
	private static final String EMAIL = "email";
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String PHONE_NUMBER = "phone_number";
	private static final String STREET = "street";
	private static final String HOUSE_NUMBER = "house_number";
	private static final String APPARTMENT_NUMBER = "appartment_number";
	
  
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		String repeatPassword = request.getParameter(REPEAT_PASSWORD);
		String email = request.getParameter(EMAIL);
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String phoneNumber = request.getParameter(PHONE_NUMBER);
		String street = request.getParameter(STREET);
		String houseNumber = request.getParameter(HOUSE_NUMBER);
		String appartmentNumber = request.getParameter(APPARTMENT_NUMBER);
		
		if (!password.equals(repeatPassword)){
			response.getWriter().println("Password not equals to repeat_password");
			return null;
		}
		
		if(DAOFactory.mySQLFactory.mySQLDAOUser.read(login) != (null)){
			response.getWriter().println("such user is exist");
			return null;
		}
		
		response.getWriter().println("go to DAO");
		Address address= new Address(street, houseNumber, appartmentNumber);
		DAOFactory.mySQLFactory.mySQLDAOAddress.create(address);
		
		response.getWriter().println("address is created");
		response.getWriter().println(address);
		
		address =DAOFactory.mySQLFactory.mySQLDAOAddress.readByAddress(street, houseNumber, appartmentNumber);
		
		
		User user = new User(login, password, firstName, lastName, email, phoneNumber, address);
		DAOFactory.mySQLFactory.mySQLDAOUser.create(user);
		
		response.getWriter().println("user is created");
		response.getWriter().println(user);
		 
		
	
		return null;
		
	}

}

