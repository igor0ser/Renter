package com.epam.renter.command.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;
import com.epam.renter.properties.Config;

public class CommandMyApplications implements ICommand {

	private static final String USER_ID = "user_id";
	private static final String LIST = "list";
	private static final String LIST_SIZE = "list_size";
	private final static String LAST_PAGE = "last_page";
	private final Logger logger = LogManager.getLogger(CommandMyApplications.class.getName());

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int userID = (int) request.getSession().getAttribute(USER_ID);
		
		//getting list of application that created by this user
		List<Application> list = DAOFactory.mySQLFactory.mySQLDAOApplication
				.findByUserID(userID);

		request.getSession().setAttribute(LIST, list);
		request.getSession().setAttribute(LIST_SIZE, list.size());
		logger.info(String.format("User (id = %d) watches his applications. He has %d applications", userID, list.size()));
		request.getSession().setAttribute(LAST_PAGE,
				Config.getInstance().getProperty(Config.MY_APPS));
		request.getRequestDispatcher(Config.getInstance().getProperty(Config.MY_APPS)).forward(request,
				response);

		return null;
	}

}
