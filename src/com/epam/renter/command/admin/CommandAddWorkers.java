package com.epam.renter.command.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.command.user.ICommand;
import com.epam.renter.entities.Application;

public class CommandAddWorkers implements ICommand {

	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm";
	private static final String DEFAULT_START = "default_start";
	private static final String DEFAULT_END = "default_end";
	private static final String APP = "app";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
			e.printStackTrace();
			return null;
		}
		String w = request.getParameter("1");

		response.getWriter().println(w);
		response.getWriter().println(app);
		response.getWriter().println(start);
		response.getWriter().println(end);

		Enumeration<String> enum1 = request.getAttributeNames();
		while (enum1.hasMoreElements()) {
			response.getWriter().println(enum1.nextElement());
		}
		return null;
	}
}
