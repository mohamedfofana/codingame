package main.java.multithreading;

import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * What is ThreadPool in Java?
 * A thread pool reuses previously created threads to execute current tasks and offers a solution to 
 * the problem of thread cycle overhead and resource thrashing. Since the thread is already existing when the request arrives, 
 * the delay introduced by thread creation is eliminated, making the application more responsive.
 * ava provides the Executor framework which is centered around the Executor interface, 
 * its sub-interface –ExecutorService and the class-ThreadPoolExecutor
 */
public class ScheduledThreadPoolExecutorMy {
	/**
	 * ScheduledThreadPoolExecutor class in Java is a subclass of ThreadPoolExecutor class defined in java.util.concurrent package. 
	 * As it is clear from its name that this class is useful when we want to schedule tasks to run repeatedly or to run after a given delay for some future time.  
	 * It creates a fixed-sized Thread Pool. So when it is initiated, it needs to be given the corePoolSize (the number of threads in the Thread pool).
	 * @param args
	 */
	/**
	 * ScheduledThreadPoolExecutor(int corePoolSize) : Creates a new ScheduledThreadPoolExecutor object with the given pool size. It is to be noted that it creates a fixed-sized Thread Pool so once the corePoolSize is given, one can not increase the size of the Thread Pool.
	 * ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) : Creates a new ScheduledThreadPoolExecutor object with the given parameters. The first parameter is the size of the Thread Pool and the second parameter is a ThreadFactory object that is used when the ScheduledThreadPoolExecutor creates a new thread.
	 * ScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler): Creates a new ScheduledThreadPoolExecutor object with the given corePoolSize(ThreadPool size) and the handler that is used when the execution of a task is rejected (when the working queue is full or execution is blocked).
	 * ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler): Creates a new ScheduledThreadPoolExecutor object with the given parameters.
	 * @param args
	 */
	 static void schedule() {
		// Creating a ScheduledThreadPoolExecutor object 
			ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(2); 

			// Creating two Runnable objects 
			Runnable task1 = new Command("task1"); 
			Runnable task2 = new Command("task2"); 

			// Printing the current time in seconds 
			System.out.println( 
					"Current time : "
							+ Calendar.getInstance().get(Calendar.SECOND)); 

			// Scheduling the first task which will execute 
			// after 2 seconds 
			threadPool.schedule(task1, 2, TimeUnit.SECONDS); 

			// Scheduling the second task which will execute 
			// after 5 seconds 
			threadPool.schedule(task2, 5, TimeUnit.SECONDS); 

			// Remember to shut down the Thread Pool 
			threadPool.shutdown(); 
	 }
	 
	 static void scheduleAtFixedRate() {
		 // Creating a ScheduledThreadPoolExecutor object 
	        ScheduledThreadPoolExecutor threadPool 
	            = new ScheduledThreadPoolExecutor(2); 
	  
	        // Creating two Runnable objects 
	        Runnable task1 = new Command("task1"); 
	        Runnable task2 = new Command("task2"); 
	  
	        // Printing the current time in seconds 
	        System.out.println( 
	            "Current time:"
	            + Calendar.getInstance().get(Calendar.SECOND)); 
	  
	        // Scheduling the first task which will execute 
	        // after 2 seconds and then repeats periodically with 
	        // a period of 8 seconds 
	        threadPool.scheduleAtFixedRate(task1, 2, 8, 
	                                       TimeUnit.SECONDS); 
	  
	        // Scheduling the second task which will execute 
	        // after 5 seconds and then there will be a delay of 
	        // 5 seconds between the completion 
	        // of one execution and the commencement of the next 
	        // execution 
	        threadPool.scheduleWithFixedDelay(task2, 5, 5, 
	                                          TimeUnit.SECONDS); 
	  
	        // Wait for 30 seconds 
	        try { 
	            Thread.sleep(30000); 
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	  
	        // Remember to shut sown the Thread Pool 
	        threadPool.shutdown();
	 }
	public static void main(String[] args) {
		
	}
}

//Class that implements the Runnable interface 
class Command implements Runnable { 
	String taskName; 
	public Command(String taskName){ 
		this.taskName = taskName; 
	} 
	public void run() { 
		System.out.println( 
				"Task name : " + this.taskName + " Current time: "
						+ Calendar.getInstance().get(Calendar.SECOND)); 
	} 
}
