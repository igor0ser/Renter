package com.epam.renter.command.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;
import com.epam.renter.properties.Config;

public class CommandMyApplications implements ICommand {

	private static final String USER_ID = "user_id";
	private static final String LIST = "list";
	private static final String LIST_SIZE = "list_size";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int userID = (int) request.getSession().getAttribute(USER_ID);

		List<Application> list = DAOFactory.mySQLFactory.mySQLDAOApplication
				.readByUserID(userID);

		request.setAttribute(LIST, list);
		request.setAttribute(LIST_SIZE, list.size());
		request.getRequestDispatcher(Config.getInstance().getProperty(Config.MY_APPS)).forward(request,
				response);

		return null;
	}

}
