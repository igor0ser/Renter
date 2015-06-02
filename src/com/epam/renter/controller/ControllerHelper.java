package com.epam.renter.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.epam.renter.command.*;

public class ControllerHelper {

	private static final String COMMAND = "command";

	private static ControllerHelper instance = null;
	HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	private ControllerHelper() {
		commands.put("login", new CommandLogIn());
		commands.put("registration", new CommandRegistration());
		commands.put("see_app_user", new CommandSeeAppUser());
		commands.put("create_app", new CommandCreateApp());
	}

	public ICommand getCommand(HttpServletRequest request) {
		ICommand command = commands.get(request.getParameter(COMMAND));
		if (command == null) {

		}
		return command;
	}

	public static ControllerHelper getInstance() {
		if (instance == null) {
			instance = new ControllerHelper();
		}
		return instance;
	}
}
