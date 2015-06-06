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

import com.epam.renter.command.user.ICommand;
import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.Status;
import com.epam.renter.entities.Work;
import com.epam.renter.entities.Worker;
import com.epam.renter.properties.Config;
import com.epam.renter.properties.Message;

public class CommandAddWorkers implements ICommand {

	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm";
	private static final String DEFAULT_START = "default_start";
	private static final String DEFAULT_END = "default_end";
	private static final String APP = "app";
	private static final String LIST_WORKERS = "list_workers";
	private static final String ADMIN_MESSAGE = "message";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		boolean error = false;

		Application app = (Application) request.getSession().getAttribute(APP);
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
		String startTime = (String) request.getSession().getAttribute(
				DEFAULT_START);
		String endTime = (String) request.getSession()
				.getAttribute(DEFAULT_END);
		Date start = null;
		Date end = null;
		try {
			start = formatter.parse(startTime);
			end = formatter.parse(endTime);
		} catch (ParseException e) {

			error = true;

		}

		app.setStart(start);
		app.setEnd(end);
		app.setStatus(Status.ASSIGNED);
		boolean isAppSaved = DAOFactory.mySQLFactory.mySQLDAOApplication
				.update(app);
		response.getWriter().println(isAppSaved);
		response.getWriter().println(app);
		if (isAppSaved) {
			List<Worker> list_worker = (List<Worker>) request.getSession()
					.getAttribute(LIST_WORKERS);

			for (Worker worker : list_worker) {
				if (request.getParameter(String.valueOf(worker.getId())) != null) {
					response.getWriter().println(worker);
					DAOFactory.mySQLFactory.mySQLDAOWork.create(new Work(app,
							worker));

				}
			}
		} else {
			error = true;
		}
		if (error) {
			request.setAttribute(ADMIN_MESSAGE, Message.getInstance()
					.getProperty(Message.ADMIN_ERROR));
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ADMIN_MESSAGE))
					.forward(request, response);
		} else {
			request.setAttribute(ADMIN_MESSAGE, Message.getInstance()
					.getProperty(Message.ADMIN_APP_IS_ASSIGNED));
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ADMIN_MESSAGE))
					.forward(request, response);
		}
		return null;
	}
}
