package main.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Like a platform thread, a virtual thread is also an instance of java.lang.Thread. 
 * However, a virtual thread isn't tied to a specific OS thread. 
 * A virtual thread still runs code on an OS thread. 
 * However, when code running in a virtual thread calls a blocking I/O operation, 
 * the Java runtime suspends the virtual thread until it can be resumed. 
 * The OS thread associated with the suspended virtual thread is now free to perform operations for other virtual threads.
 */
/**
 * Use virtual threads in high-throughput concurrent applications, 
 * especially those that consist of a great number of concurrent tasks that spend much of their time waiting. 
 * Server applications are examples of high-throughput applications 
 * because they typically handle many client requests that perform blocking I/O operations such as fetching resources.
 */
public class VirtualThread {

	/**
	 * Creating a Virtual Thread with the Thread Class and the Thread.Builder Interface
	 */
	
	/**
	 * creates and starts a virtual thread that prints a message. It calls the join method to wait for the virtual thread to terminate.
	 * @throws InterruptedException 
	 */
	static void createVT() throws InterruptedException {
		Thread thread = Thread.ofVirtual().start(() -> System.out.println("Hello"));
		thread.join();
	}
	
	/**
	 * The Thread.Builder interface lets you create threads with common Thread properties such as the thread's name. 
	 * The Thread.Builder.OfPlatform subinterface creates platform threads while Thread.Builder.OfVirtual creates virtual threads.
	 * @throws InterruptedException 
	 */
	/**
	 * creates a virtual thread named MyThread with the Thread.Builder interface:
	 */
	static void createVTWithThreadBuilder() throws InterruptedException {
		Thread.Builder builder = Thread.ofVirtual().name("MyThread");
		Runnable task = () -> {
		    System.out.println("Running thread");
		};
		Thread t = builder.start(task);
		System.out.println("Thread t name: " + t.getName());
		t.join();
	}
	/**
	 *  creates and starts two virtual threads with Thread.Builder:
	 */
	static void create2VTWithThreadBuilder() throws InterruptedException {
		Thread.Builder builder = Thread.ofVirtual().name("worker-", 0);
		Runnable task = () -> {
		    System.out.println("Thread ID: " + Thread.currentThread().threadId());
		};

		// name "worker-0"
		Thread t1 = builder.start(task);   
		t1.join();
		System.out.println(t1.getName() + " terminated");

		// name "worker-1"
		Thread t2 = builder.start(task);   
		t2.join();  
		System.out.println(t2.getName() + " terminated");
	}
	
	/**
	 * Creating and Running a Virtual Thread with the Executors.newVirtualThreadPerTaskExecutor() Method
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * creates an ExecutorService with the Executors.newVirtualThreadPerTaskExecutor() method. 
	 * Whenever ExecutorService.submit(Runnable) is called, a new virtual thread is created and started to run the task. 
	 * @param args
	 * @throws InterruptedException
	 */
	static void executorService() {
		try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
		    Future<?> future = myExecutor.submit(() -> System.out.println("Running thread"));
		    future.get();
		    System.out.println("Task completed");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		createVT();
		createVTWithThreadBuilder();
		create2VTWithThreadBuilder();
	}
}
