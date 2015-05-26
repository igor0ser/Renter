package com.epam.renter.entities;

public class Dispatcher extends AbstractUser {

	private static final long serialVersionUID = 1L;

	public Dispatcher(String login, String password, String lastName,
			String firstName, String email, String phoneNumber) {
		super(login, password, lastName, firstName, email, phoneNumber);
	}

	public Dispatcher(int idDispatcher, String login, String password,
			String lastName, String firstName, String email, String phoneNumber) {
		super(idDispatcher, login, password, lastName, firstName, email,
				phoneNumber);
	}

	public Dispatcher() {
	}

	@Override
	public String toString() {
		return "Dispatcher" + super.toString() + "]";
	}

}
