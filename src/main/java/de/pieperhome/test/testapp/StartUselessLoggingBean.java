package de.pieperhome.test.testapp;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.inject.Named;

@Named("startUselessLoggingBean")
@Stateless
public class StartUselessLoggingBean {
	
	@Resource(lookup="java:jboss/ee/concurrency/factory/LoggingThreadFactory")
	private ManagedThreadFactory threadFactory;

	public void startThreads() {
		LoggingThread loggingThread1 = new LoggingThread();
		loggingThread1.setThreadNumber(1);
		Thread thread = threadFactory.newThread(loggingThread1);
		thread.start();

		LoggingThread loggingThread2 = new LoggingThread();
		loggingThread2.setThreadNumber(2);
		Thread thread2 = threadFactory.newThread(loggingThread2);
		thread2.start();

		LoggingThread loggingThread3 = new LoggingThread();
		loggingThread3.setThreadNumber(3);
		Thread thread3 = threadFactory.newThread(loggingThread3);
		thread3.start();
	}
}
