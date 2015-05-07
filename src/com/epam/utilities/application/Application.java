package com.epam.utilities.application;

import java.util.Date;

import com.epam.utilities.users.*;

public class Application {
	public Application(Renter renter, Date creationDate, Date desirableDate,
			String about) {
		this.renter = renter;
		this.creationDate = creationDate;
		this.desirableDate = desirableDate;
		this.about = about;
		this.status = Status.CREATED;
	}
public Application(Renter renter, Date creationDate, Date desirableDate,
			Date completeDate, String about, Status status,
			Brigade brigade) {
		this.renter = renter;
		this.creationDate = creationDate;
		this.desirableDate = desirableDate;
		this.completeDate = completeDate;
		this.about = about;
		this.status = status;
		this.brigade = brigade;
	}
private Renter renter;
private Date creationDate;
private Date desirableDate;
private Date completeDate;
private String about;
private Status status;
Brigade brigade;

}
