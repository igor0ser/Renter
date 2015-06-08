package com.epam.renter.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.properties.Config;

public class CommandChangeLanguage implements ICommand {
	private final static String LANG = "lang";
	private final static String LANGUAGE = "language";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String lang = request.getParameter(LANG);
		request.getSession().setAttribute(LANGUAGE, lang);
		
		String z = request.getHeader("Referer");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// TODO Auto-generated method stub
		return null;
	}

}
