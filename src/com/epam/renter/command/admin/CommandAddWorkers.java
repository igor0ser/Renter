package com.epam.renter.command.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.renter.command.user.ICommand;
import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;
import com.epam.renter.entities.Work;
import com.epam.renter.entities.Worker;
import com.epam.renter.properties.Config;
import com.epam.renter.properties.Message;

// this command assign workers to application
public class CommandAddWorkers implements ICommand {

	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm";
	private static final String DEFAULT_START = "default_start";
	private static final String DEFAULT_END = "default_end";
	private static final String APP = "app";
	private static final String LIST_WORKERS = "list_workers";
	private static final String ADMIN_MESSAGE = "message";
	private final static String LAST_PAGE = "last_page";
	private final Logger logger = LogManager.getLogger(CommandCreatedApps.class
			.getName());

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// error tries to catch exceptions
		boolean error = false;

		Application app = (Application) request.getSession().getAttribute(APP);
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
		String startTime = (String) request.getSession().getAttribute(
				DEFAULT_START);
		String endTime = (String) request.getSession()
				.getAttribute(DEFAULT_END);
		Date start = null;
		Date end = null;
		// parsing dates
		try {
			start = formatter.parse(startTime);
			end = formatter.parse(endTime);
		} catch (ParseException e) {
			logger.error(String.format(
					"Date parse error. startTime = %s, endTime = %s", start,
					end)+e);
			error = true;

		}
		// changing application to assigned
		app.setStart(start);
		app.setEnd(end);
		app.setStatus(Status.ASSIGNED);
		// changing application to assigned in DB
		boolean isAppSaved = DAOFactory.mySQLFactory.mySQLDAOApplication
				.update(app);
		if (isAppSaved) {
			
			List<Worker> list_worker = (List<Worker>) request.getSession()
					.getAttribute(LIST_WORKERS);

			for (Worker worker : list_worker) {
				if (request.getParameter(String.valueOf(worker.getId())) != null) {
					// saving list of works
					boolean flag = DAOFactory.mySQLFactory.mySQLDAOWork
							.create(new Work(app, worker));
					if (!flag) {
						error = true;
						logger.error(String
								.format("Work wasn't saved to DB. Worker = %s ",
										worker));
					}
				}
			}
		} else {
			error = true;
			logger.error(String.format(
					"Application wasn't saved to DB. Application = %s ", app));
		}
		if (error) {
			request.getSession().setAttribute(ADMIN_MESSAGE,
					Message.getInstance().getProperty(Message.ADMIN_ERROR));
			// if error - message about error
		} else {
			request.getSession().setAttribute(
					ADMIN_MESSAGE,
					Message.getInstance().getProperty(
							Message.ADMIN_APP_IS_ASSIGNED));
			// if no error - the application was assigned
			logger.error(String.format(
					"Application was assigned. Application = %s", app));
		}

		request.getSession().setAttribute(LAST_PAGE,
				Config.getInstance().getProperty(Config.ADMIN_MESSAGE));
		request.getRequestDispatcher(
				Config.getInstance().getProperty(Config.ADMIN_MESSAGE))
				.forward(request, response);
		return null;
	}
}
