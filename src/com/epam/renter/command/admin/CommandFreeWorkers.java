package com.epam.renter.command.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.command.user.ICommand;
import com.epam.renter.entities.TypeOfWork;
import com.epam.renter.entities.Worker;
import com.epam.renter.properties.Config;
import com.epam.renter.service.ServiceWork;

public class CommandFreeWorkers implements ICommand {

	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm";
	private static final String START = "start";
	private static final String END = "end";
	private static final String IS_CHECKED = "is_checked";
	private static final String LIST = "list";
	private static final String LIST_SIZE = "list_size";
	private static final String SHOW_ALL = "show-all";
	private static final String DEFAULT_START = "default_start";
	private static final String DEFAULT_END = "default_end";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
		String startTime = request.getParameter(START);
		String endTime = request.getParameter(END);
		boolean showAll = (request.getParameter(SHOW_ALL) != null);

		Date start = null;
		Date end = null;
		try {
			start = formatter.parse(startTime);
			end = formatter.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		List<Worker> freeWorkers = (showAll) ? ServiceWork.getFreeWorkers(
				start, end) : ServiceWork.getFreeWorkers(TypeOfWork.ELECTRIC,
				start, end);
		request.setAttribute(LIST, freeWorkers);
		request.setAttribute(LIST_SIZE, freeWorkers.size());

		request.getSession().setAttribute(DEFAULT_START, startTime);
		request.getSession().setAttribute(DEFAULT_END, endTime);
		request.setAttribute(IS_CHECKED, showAll);
		request.getRequestDispatcher(
				Config.getInstance().getProperty(Config.ADMIN_HANDLE_APP))
				.forward(request, response);

		return null;
	}
}
