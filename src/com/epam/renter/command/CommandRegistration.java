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
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String EMAIL = "email";
	private static final String PHONE_NUMBER = "phone_number";
	private static final String STREET = "street";
	private static final String HOUSE = "house";
	private static final String APPARTMENT = "appartment";
	private static final String USER_ID = "user_id";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		String repeatPassword = request.getParameter(REPEAT_PASSWORD);

		if (!password.equals(repeatPassword)) {
			request.setAttribute("error",
					"Password doesn't equals to Repeat Password!");
			request.getRequestDispatcher("error_login.jsp").forward(request,
					response);
			return null;
		}

		if (DAOFactory.mySQLFactory.mySQLDAOUser.findByLogin(login) != null) {
			request.setAttribute("error",
					"Sorry, this login is already in use!");
			request.getRequestDispatcher("error_login.jsp").forward(request,
					response);
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
			request.setAttribute("user", user);
			request.getRequestDispatcher("welcome.jsp").forward(request,
					response);
		} else {
			request.setAttribute("error",
					"Sorry, something goes wrong :( Please try again later.");
			request.getRequestDispatcher("error_login.jsp").forward(request,
					response);
			return null;
		}

		return null;
	}
}
