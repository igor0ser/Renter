package com.epam.renter.entities;

public class Dispatcher extends AbstractUser {

	private static final long serialVersionUID = 1L;

	public Dispatcher(String login, String password, String firstName,
			String lastName, String email, String phoneNumber) {
		super(login, password, firstName, lastName, email, phoneNumber);
	}

	public Dispatcher(int idDispatcher, String login, String password,
			String firstName, String lastName, String email, String phoneNumber) {
		super(idDispatcher, login, password, firstName, lastName, email,
				phoneNumber);
	}

	public Dispatcher() {
	}

	@Override
	public String toString() {
		return "Dispatcher" + super.toString() + "]";
	}

}
