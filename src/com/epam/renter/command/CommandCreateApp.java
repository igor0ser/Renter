package com.epam.renter.command;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.TypeOfWork;
import com.epam.renter.entities.User;
import com.epam.renter.properties.Config;

public class CommandCreateApp implements ICommand {

	private static final String USER_ID = "user_id";
	private static final String ABOUT = "about";
	private static final String TYPE = "type_of_work";
	private static final String DESIRABLE = "desirable";
	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);

		String about = request.getParameter(ABOUT);
		String type = request.getParameter(TYPE);
		TypeOfWork typeOfWork = TypeOfWork.valueOf(type);
		String desirableTime = request.getParameter(DESIRABLE);
		int userID = (int) request.getSession().getAttribute(USER_ID);
		Date desirable = null;
		try {
			desirable = formatter.parse(desirableTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User(userID);
		Application application = new Application(user, about, typeOfWork,
				desirable);

		boolean flag = DAOFactory.mySQLFactory.mySQLDAOApplication
				.create(application);

		if (flag) {
			request.getRequestDispatcher(Config.getInstance().getProperty(Config.THANK_YOU)).forward(request,
					response);
		} else {
			request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_DB))
					.forward(request, response);
		}

		return null;
	}

}
