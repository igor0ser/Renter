package com.epam.renter.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.User;

public class CommandLogIn implements ICommand {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String USER_ID = "user_id";


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN);
		String password =request.getParameter(PASSWORD);

		User user = DAOFactory.mySQLFactory.mySQLDAOUser.findByLogin(login);

		if (user == null) {
			request.setAttribute("error",
					"Wrong login");
			request.getRequestDispatcher("error_login.jsp").forward(request,
					response);
			
		} else if (!user.getPassword().equals(password)) {
			request.setAttribute("error",
					"Wrong password");
			request.getRequestDispatcher("error_login.jsp").forward(request,
					response);
		} else {
			request.setAttribute("user", user);
			request.getSession().setAttribute(LOGIN, login);
			request.getSession().setAttribute(USER_ID, user.getId());
			request.getRequestDispatcher("welcome.jsp").forward(request,
					response);
		}

		return null;

	}

}
