package com.epam.renter.entities;

public class Worker extends AbstractUser {

	private static final long serialVersionUID = 1L;

	public Worker() {
	}

	public Worker(String login, String password, String lastName,
			String firstName, String email, String phoneNumber,
			TypeOfWork typeOfWork) {
		super(login, password, lastName, firstName, email, phoneNumber);
		this.typeOfWork = typeOfWork;
	}

	public Worker(int id, String login, String password, String lastName,
			String firstName, String email, String phoneNumber) {
		super(id, login, password, lastName, firstName, email, phoneNumber);
	}

	private TypeOfWork typeOfWork;

	public TypeOfWork getTypeOfWork() {
		return typeOfWork;
	}

	public void setTypeOfWork(TypeOfWork typeOfWork) {
		this.typeOfWork = typeOfWork;
	}

	@Override
	public String toString() {
		return "Worker " + super.toString() + ", typeOfWork=" + typeOfWork
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((typeOfWork == null) ? 0 : typeOfWork.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (typeOfWork != other.typeOfWork)
			return false;
		return true;
	}

}
