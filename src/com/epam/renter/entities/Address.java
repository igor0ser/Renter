package com.epam.renter.entities;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;

	public Address() {
	}

	public Address(String street, String house, String appartment) {
		super();
		this.street = street;
		this.house = house;
		this.appartment = appartment;
	}

	public Address(int id, String street, String house, String appartment) {
		super();
		this.id = id;
		this.street = street;
		this.house = house;
		this.appartment = appartment;
	}

	private int id;
	private String street;
	private String house;
	private String appartment;

	public int getId() {
		return id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getHouse() {
		return house;
	}
	
	public String getAppartment() {
		return appartment;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((appartment == null) ? 0 : appartment.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (appartment == null) {
			if (other.appartment != null)
				return false;
		} else if (!appartment.equals(other.appartment))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", house=" + house
				+ ", appartment=" + appartment + "]";
	}


}
