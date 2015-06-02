package com.epam.renter.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;

public class CommandSeeAppUser implements ICommand {

	private static final String USER_ID = "user_id";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int userID = (int) request.getSession().getAttribute(USER_ID);

		List<Application> list = DAOFactory.mySQLFactory.mySQLDAOApplication
				.readByUserID(userID);

		request.setAttribute("list", list);
		request.setAttribute("list_size", list.size());
		request.getRequestDispatcher("my_applications.jsp").forward(request,
				response);

		return null;
	}

}
