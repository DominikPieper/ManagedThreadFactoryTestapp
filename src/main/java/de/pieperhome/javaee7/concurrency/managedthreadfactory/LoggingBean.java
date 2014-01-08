package de.pieperhome.javaee7.concurrency.managedthreadfactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.inject.Named;

@Named("startUselessLoggingBean")
@Stateless
public class LoggingBean {
	
	@Resource(lookup="java:jboss/ee/concurrency/factory/LoggingThreadFactory")
	private ManagedThreadFactory threadFactory;

	public void startThreads() {
		Thread thread = threadFactory.newThread(new LoggingTask(1));
		thread.start();

		Thread thread2 = threadFactory.newThread(new LoggingTask(2));
		thread2.start();

		Thread thread3 = threadFactory.newThread(new LoggingTask(3));
		thread3.start();
	}
}
