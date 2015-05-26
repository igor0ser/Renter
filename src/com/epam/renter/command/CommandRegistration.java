package com.epam.renter.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.datasource.DAOFactory;
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
		
		User user = DAOFactory.mySQLFactory.mySQLDAOUser.read(login);
		
		if (user == null){
			response.getWriter().println("Wrong login");
		}
		else if (!user.getPassword().equals(password)){
			response.getWriter().println("Wrong password");
			}
		else{
			request.getRequestDispatcher("application.jsp").forward(request, response);
		}
	
		return null;
		
	}

}

