package com.epam.renter.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Address;
import com.epam.renter.entities.User;
import com.epam.renter.properties.Config;
import com.epam.renter.properties.Message;

public class CommandRegistration implements ICommand {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String REPEAT_PASSWORD = "repeat_password";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String EMAIL = "email";
	private static final String PHONE_NUMBER = "phone_number";
	private static final String STREET = "street";
	private static final String HOUSE = "house";
	private static final String APPARTMENT = "appartment";
	private static final String USER_ID = "user_id";
	private static final String ERROR = "error";
	private static final String USER = "user";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		String repeatPassword = request.getParameter(REPEAT_PASSWORD);

		if (!password.equals(repeatPassword)) {
			request.setAttribute(
					ERROR,
					Message.getInstance().getProperty(
							Message.WRONG_REP_PASSWORD));
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ERROR_LOGIN))
					.forward(request, response);
			return null;
		}

		if (DAOFactory.mySQLFactory.mySQLDAOUser.findByLogin(login) != null) {
			request.setAttribute(ERROR,
					Message.getInstance().getProperty(Message.WRONG_LOGIN_USED));
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ERROR_LOGIN))
					.forward(request, response);
			return null;
		}

		String name = request.getParameter(NAME);
		String surname = request.getParameter(SURNAME);
		String email = request.getParameter(EMAIL);

		response.getWriter().println(surname);
		String phoneNumber = request.getParameter(PHONE_NUMBER);
		String street = request.getParameter(STREET);
		String houseNumber = request.getParameter(HOUSE);
		String appartmentNumber = request.getParameter(APPARTMENT);

		User user = new User(login, password, name, surname, email, phoneNumber);
		if (DAOFactory.mySQLFactory.mySQLDAOUser.create(user)) {
			user = DAOFactory.mySQLFactory.mySQLDAOUser.findByLogin(login);
			Address address = new Address(street, houseNumber,
					appartmentNumber, user);
			DAOFactory.mySQLFactory.mySQLDAOAddress.create(address);
			request.getSession().setAttribute(LOGIN, login);
			request.getSession().setAttribute(NAME, name);
			request.getSession().setAttribute(USER_ID, user.getId());
			request.setAttribute(USER, user);
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.WELCOME)).forward(
					request, response);
		} else {
			request.setAttribute(ERROR,
					Message.getInstance().getProperty(Message.RANDOM_ERROR));
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ERROR_LOGIN))
					.forward(request, response);
			return null;
		}

		return null;
	}
}
