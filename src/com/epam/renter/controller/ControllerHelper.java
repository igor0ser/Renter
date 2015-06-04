package com.epam.renter.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.epam.renter.command.admin.CommandAddWorkers;
import com.epam.renter.command.admin.CommandCreatedApps;
import com.epam.renter.command.admin.CommandFreeWorkers;
import com.epam.renter.command.admin.CommandHandleApp;
import com.epam.renter.command.user.CommandCreateApp;
import com.epam.renter.command.user.CommandLogIn;
import com.epam.renter.command.user.CommandLogOut;
import com.epam.renter.command.user.CommandMyApplications;
import com.epam.renter.command.user.CommandRegistration;
import com.epam.renter.command.user.ICommand;

public class ControllerHelper {

	private static final String COMMAND = "command";

	private static ControllerHelper instance = null;
	HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	private ControllerHelper() {
		commands.put("login", new CommandLogIn());
		commands.put("logout", new CommandLogOut());
		commands.put("registration", new CommandRegistration());
		commands.put("see_app_user", new CommandMyApplications());
		commands.put("create_app", new CommandCreateApp());
		commands.put("created_apps", new CommandCreatedApps());
		commands.put("handle_app", new CommandHandleApp());
		commands.put("free_workers", new CommandFreeWorkers());
		commands.put("add_workers", new CommandAddWorkers());
				
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
