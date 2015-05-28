package com.epam.renter.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.entities.AbstractUser;
import com.epam.renter.service.ServiceAbstractUser;

public class CommandCreateApplication implements ICommand {

	private static final String LOGIN = "login";
	
  
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		
		AbstractUser user = ServiceAbstractUser.getUser(login);
		
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