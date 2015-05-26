package com.epam.renter.entities;

import java.util.Date;

public class Application {
	
	public Application(){
		this.user = new User();
		this.worker = new Worker();
	};
	
	public Application(User user, Date desirableDate, String about,
			TypeOfWork typeOfWork) {
		this.user = user;
		this.creationDate = new Date();
		this.desirableDate = desirableDate;
		this.about = about;
		this.status = Status.CREATED;
		this.typeOfWork = typeOfWork;
	}
	
	public Application(int id, User user, Date desirableDate, String about,
			TypeOfWork typeOfWork) {
		this.id = id;
		this.user = user;
		this.creationDate = new Date();
		this.desirableDate = desirableDate;
		this.about = about;
		this.status = Status.CREATED;
		this.typeOfWork = typeOfWork;
	}

	private int id;
	private User user;
	private String about;
	private Date creationDate;
	private Date desirableDate;
	private Date completeDate;
	private Status status;
	private Worker worker;
	private TypeOfWork typeOfWork;
	
	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getAbout() {
		return about;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getDesirableDate() {
		return desirableDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public Status getStatus() {
		return status;
	}

	public Worker getWorker() {
		return worker;
	}

	public TypeOfWork getTypeOfWork() {
		return typeOfWork;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setDesirableDate(Date desirableDate) {
		this.desirableDate = desirableDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public void setTypeOfWork(TypeOfWork typeOfWork) {
		this.typeOfWork = typeOfWork;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result
				+ ((completeDate == null) ? 0 : completeDate.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((desirableDate == null) ? 0 : desirableDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((typeOfWork == null) ? 0 : typeOfWork.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((worker == null) ? 0 : worker.hashCode());
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
		Application other = (Application) obj;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (completeDate == null) {
			if (other.completeDate != null)
				return false;
		} else if (!completeDate.equals(other.completeDate))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (desirableDate == null) {
			if (other.desirableDate != null)
				return false;
		} else if (!desirableDate.equals(other.desirableDate))
			return false;
		if (status != other.status)
			return false;
		if (typeOfWork != other.typeOfWork)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (worker == null) {
			if (other.worker != null)
				return false;
		} else if (!worker.equals(other.worker))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", user=" + user + ", about=" + about
				+ ", creationDate=" + creationDate + ", desirableDate="
				+ desirableDate + ", completeDate=" + completeDate
				+ ", status=" + status + ", worker=" + worker + ", typeOfWork="
				+ typeOfWork + "]";
	}

}
