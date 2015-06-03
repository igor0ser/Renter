package com.epam.renter.command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.command.user.ICommand;
import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Address;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.User;
import com.epam.renter.properties.Config;

public class CommandHandleApp implements ICommand {

	private static final String APP_ID = "app_id";
	private static final String APP = "app";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String app_id = request.getParameter(APP_ID);
		int id = Integer.parseInt(app_id);
		Application app = DAOFactory.mySQLFactory.mySQLDAOApplication
				.findByID(id);
		User user = DAOFactory.mySQLFactory.mySQLDAOUser.findByID(app.getUser()
				.getId());
		Address address = DAOFactory.mySQLFactory.mySQLDAOAddress
				.findByUser(user);
		user.setAddress(address);
		app.setUser(user);

		response.getWriter().println(app);
		request.setAttribute(APP, app);
		request.getRequestDispatcher(
				Config.getInstance().getProperty(Config.ADMIN_HANDLE_APP))
				.forward(request, response);
		return null;
	}

}
