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

public class CommandSetAppComplete implements ICommand {

	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm";
	private static final String DEFAULT_START = "default_start";
	private static final String DEFAULT_END = "default_end";
	private static final String APP_ID = "app_id";
	private static final String LIST_WORKERS = "list_workers";
	private static final String ADMIN_MESSAGE = "message";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter(APP_ID);
		int appId = Integer.parseInt(id);
		Application app = DAOFactory.mySQLFactory.mySQLDAOApplication
				.findByID(appId);
		app.setStatus(Status.COMPLETED);
		boolean flag = DAOFactory.mySQLFactory.mySQLDAOApplication.update(app);
		if (!flag) {
			request.setAttribute(ADMIN_MESSAGE, Message.getInstance()
					.getProperty(Message.ADMIN_ERROR));
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ADMIN_MESSAGE))
					.forward(request, response);
		} else {
			String mes = Message.getInstance().getProperty(
					Message.AN_APPLICATION)
					+ app.getAbout()
					+ Message.getInstance().getProperty(
							Message.ADMIN_APP_IS_COMPLETED);
			request.setAttribute(ADMIN_MESSAGE, mes);
			request.getRequestDispatcher(
					Config.getInstance().getProperty(Config.ADMIN_MESSAGE))
					.forward(request, response);
		}
		return null;
	}
}
