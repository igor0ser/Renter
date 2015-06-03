package com.epam.renter.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Admin;
import com.epam.renter.entities.User;
import com.epam.renter.properties.Config;

public class CommandLogIn implements ICommand {

	private static final String LOGIN = "login";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	private static final String USER_ID = "user_id";
	private static final String ERROR = "error";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);

		User user = DAOFactory.mySQLFactory.mySQLDAOUser.findByLogin(login);

		if (user == null) {
			request.setAttribute(ERROR, "Wrong login");
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ERROR_LOGIN))
					.forward(request, response);

		} else if (!user.getPassword().equals(password)) {
			request.setAttribute(ERROR, "Wrong password");
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ERROR_LOGIN))
					.forward(request, response);
		} else {
			Admin admin = DAOFactory.mySQLFactory.MYSQLDAOAdmin
					.findByUserID(user.getId());
			if (admin != null) {
				request.getSession().setAttribute(LOGIN, login);
				request.getRequestDispatcher(
						Config.getInstance().getProperty(Config.ADMIN_WELCOME))
						.forward(request, response);
			} else {
				request.setAttribute("user", user);
				request.getSession().setAttribute(LOGIN, login);
				request.getSession().setAttribute(USER_ID, user.getId());
				request.getRequestDispatcher(
						Config.getInstance().getProperty(Config.WELCOME))
						.forward(request, response);
			}

		}
		return null;
	}
}
