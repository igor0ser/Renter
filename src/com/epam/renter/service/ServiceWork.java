package com.epam.renter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.epam.renter.datasource.DAOFactory;
import com.epam.renter.entities.Application;
import com.epam.renter.entities.TypeOfWork;
import com.epam.renter.entities.Work;
import com.epam.renter.entities.Worker;

public class ServiceWork {

	public static List<Worker> getFreeWorkers(Date start, Date end) {
		List<Worker> allWorkers = DAOFactory.mySQLFactory.mySQLDAOWorker
				.readAll();
		return getFreeWorkers(allWorkers, start, end);
	}

	public static List<Worker> getFreeWorkers(TypeOfWork typeOfWork,
			Date start, Date end) {
		List<Worker> allWorkers = DAOFactory.mySQLFactory.mySQLDAOWorker
				.findByTypeOfWork(typeOfWork);
		return getFreeWorkers(allWorkers, start, end);
	}

	private static boolean isOverlapping(Date start1, Date end1, Date start2,
			Date end2) {
		return !start1.after(end2) && !start2.after(end1);
	}

	private static List<Worker> getFreeWorkers(List<Worker> allWorkers,
			Date start, Date end) {
		List<Worker> freeWorkers = new ArrayList<Worker>();
		for (Worker worker : allWorkers) {
			List<Work> workList = DAOFactory.mySQLFactory.mySQLDAOWork
					.findByWorker(worker);
			boolean flag = true;
			for (Work work : workList) {
				Application app = DAOFactory.mySQLFactory.mySQLDAOApplication
						.findByID(work.getApplication().getId());
				if (isOverlapping(start, end, app.getStart(), app.getEnd())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				freeWorkers.add(worker);
			}
		}
		return freeWorkers;
	}

	public static List<Worker> getWorkersByApp(Application app) {
		List<Work> workList = DAOFactory.mySQLFactory.mySQLDAOWork
				.findByApplication(app);
		List<Worker> workerList = new ArrayList<>();
		for (Work work : workList) {
			int idWorker = work.getWorker().getId();
			Worker worker = DAOFactory.mySQLFactory.mySQLDAOWorker
					.findByID(idWorker);
			workerList.add(worker);
		}
		return workerList;
	}

}
