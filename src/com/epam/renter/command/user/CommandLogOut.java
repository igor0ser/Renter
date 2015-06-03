package com.epam.renter.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.properties.Config;

public class CommandLogOut implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher(Config.getInstance().getProperty(Config.INDEX)).forward(request,
				response);
		// TODO Auto-generated method stub
		return null;
	}

}
