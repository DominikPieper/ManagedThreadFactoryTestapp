package de.pieperhome.javaee7.concurrency.managedthreadfactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingTask implements Runnable {

	private Logger logger = Logger.getLogger(getClass().getSimpleName());
	private int id = 0;
	private java.util.Random random = new java.util.Random(System.currentTimeMillis());

	public LoggingTask(int id) {
		this.id = id;
	}

	public void run() {
		int sleepInt = random.nextInt(10000);
		logger.log(Level.INFO, "New thread..");
		logger.log(Level.INFO, "Sleep " + sleepInt);
		try {
			// do whatever you want here..
			for(int i=0; i<=10; i++) {
				logger.log(Level.INFO, "Thread " + id + " : " + i);
				Thread.sleep(sleepInt);
			}
		} catch (InterruptedException ie) {
			logger.log(Level.WARNING, "Interrupted", ie);
		}
	}
}
