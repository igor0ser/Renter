package com.epam.renter.command.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.command.user.ICommand;
import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Address;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;
import com.epam.renter.entities.User;
import com.epam.renter.properties.Config;

public class CommandCompletedApps implements ICommand {

	private static final String LIST = "list";
	private static final String LIST_SIZE = "list_size";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Application> list = DAOFactory.mySQLFactory.mySQLDAOApplication
				.findByStatus(Status.COMPLETED);
		for (Application app : list) {
			User user = DAOFactory.mySQLFactory.mySQLDAOUser.findByID(app
					.getUser().getId());
			Address address = DAOFactory.mySQLFactory.mySQLDAOAddress
					.findByUser(user);
			user.setAddress(address);
			app.setUser(user);
		}

		request.setAttribute(LIST, list);
		request.setAttribute(LIST_SIZE, list.size());
		request.getRequestDispatcher(
				Config.getInstance().getProperty(Config.ADMIN_CREATED_APPS))
				.forward(request, response);
		return null;
	}

}
