package com.epam.renter.command.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.command.user.ICommand;
import com.epam.renter.properties.Config;

public class CommandFreeWorkers implements ICommand {

	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm";
	private static final String START = "start";
	private static final String END= "end";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
		String startTime = request.getParameter(START);
		String endTime = request.getParameter(END);
		
		if (startTime == null){
			return null;
		}
		
		Date start = null;
		Date end = null;
		try {
			start = formatter.parse(startTime);
			end = formatter.parse(endTime);
		} catch (ParseException e) {
					e.printStackTrace();
		}
		request.setAttribute(START, start);
		request.setAttribute(END, end);
		request.getRequestDispatcher(
				Config.getInstance().getProperty(Config.ADMIN_HANDLE_APP)).include(request, response);
		return null;
	}

}
