package com.epam.renter.runner;

import java.util.Date;
import java.util.List;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.*;

public class Runner {

	public static void main(String[] args) {
		System.out.println("Start");
		String login = "user1";
		String password = "user1";
		User user = DAOFactory.mySQLFactory.mySQLDAOUser.read(login);
		
		//System.out.println(user);
		if (user == null){
			System.out.println("Wrong login");
		}
		else if (!user.getPassword().equals(password)){
			System.out.println("Wrong password");
		}
		else{
			System.out.println("application.jsp");
		}
		System.out.println("End");
	}

		public static void userDAO() {
		User w = new User("john", "1111", "John", "McLane",
				"jjjj@gmail.com", "044-172-22-22", new Address(1, "","",""));

		//boolean x = DAOFactory.mySQLFactory.mySQLDAOUser.create(w);
	//System.out.println(x);

		List<User> list = DAOFactory.mySQLFactory.mySQLDAOUser.readAll();
		for (User worker : list) {
			System.out.println(worker);
		}
	
		User w1 = DAOFactory.mySQLFactory.mySQLDAOUser.read(2);
		User w2 = DAOFactory.mySQLFactory.mySQLDAOUser.read("john");
		
		System.out.println(w1);
		System.out.println(w2);
		
		

	}
	
	public static void workerDAO() {
		Worker w = new Worker("john", "1111", "John", "McLane",
				"jjjj@gmail.com", "044-172-22-22", TypeOfWork.AIR_CONDITIONING);

		boolean x = DAOFactory.mySQLFactory.mySQLDAOWorker.create(w);
		System.out.println(x);

		List<Worker> list = DAOFactory.mySQLFactory.mySQLDAOWorker.readAll();
		for (Worker worker : list) {
			System.out.println(worker);
		}
		
		Worker w1 = DAOFactory.mySQLFactory.mySQLDAOWorker.read(2);
		Worker w2 = DAOFactory.mySQLFactory.mySQLDAOWorker.read("john");
		
		System.out.println(w1);
		System.out.println(w2);
		
		

	}

	public static void dispatcherDAO() {
		Dispatcher d0 = new Dispatcher("carragher", "0000", "Jamie",
				"Carragher", "java@gmail.com", "044-545-12-89");

		boolean x = DAOFactory.mySQLFactory.mySQLDAODispatcher.create(d0);
		System.out.println(x);

		Dispatcher d = DAOFactory.mySQLFactory.mySQLDAODispatcher.read(3);
		System.out.println(d);

		Dispatcher d1 = DAOFactory.mySQLFactory.mySQLDAODispatcher.read("Igor");
		System.out.println(d1);

		List<Dispatcher> list = DAOFactory.mySQLFactory.mySQLDAODispatcher
				.readAll();

		for (Dispatcher dispatcher : list) {
			System.out.println(dispatcher);
		}
	}

	public static void applicationDAO() {
		User u1 = new User();
		u1.setId(2);
		Application x = new Application(u1, new Date(), "very hot in appartment", TypeOfWork.AIR_CONDITIONING);
		boolean b = DAOFactory.mySQLFactory.mySQLDAOApplication.create(x);
		
		System.out.println(b);

		List<Application> list = DAOFactory.mySQLFactory.mySQLDAOApplication
				.readAll();
		for (Application application : list) {
			System.out.println(application);
		}
		
		System.out.println();
		
		List<Application> list1 = DAOFactory.mySQLFactory.mySQLDAOApplication.read(Status.ASSIGNED);
				
		for (Application application : list1) {
			System.out.println(application);
		}
		System.out.println();
		List<Application> list2 = DAOFactory.mySQLFactory.mySQLDAOApplication.read(2);
		
		for (Application application : list2) {
			System.out.println(application);
		}
		
	}

	public static void addressDAO() {
		Address address4 = new Address("Spas'ka", "29", "137");
		boolean x = DAOFactory.mySQLFactory.mySQLDAOAddress.create(address4);
		System.out.println(x);
		Address address1 = DAOFactory.mySQLFactory.mySQLDAOAddress.read(6);
		System.out.println(address1);
	}
}
