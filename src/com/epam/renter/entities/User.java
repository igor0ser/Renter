package com.epam.renter.entities;

public class User extends AbstractUser {

	private static final long serialVersionUID = 1L;

	public User() {
		super();
		address = new Address();
	}

	public User(String login, String password, String firstName,
			String lastName, String email, String phoneNumber, Address address) {
		super(login, password, lastName, firstName, email, phoneNumber);
		this.address = address;
	}

	public User(int id, String login, String password, String firstName,
			String lastName, String email, String phoneNumber, Address address) {
		super(id, login, password, lastName, firstName, email, phoneNumber);
		this.address = address;
	}

	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User " + super.toString() + ", address=" + address + "]";
	}

}
