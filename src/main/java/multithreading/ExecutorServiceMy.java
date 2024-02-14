package main.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMy {

	public static void main(String[] args) {
		//		ExecutorService executor = Executors.newFixedThreadPool(10);
		ExecutorService executorService = 
				new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,   
						new LinkedBlockingQueue<Runnable>());

		Runnable runnableTask = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		/**
		 * The execute() method is void and doesn’t give any possibility to get the result 
		 * of a task’s execution or to check the task’s status (is it running):
		 */
		executorService.execute(runnableTask);

		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(300);
			return "Task's execution";
		};
		/**
		 *submit() submits a Callable or a Runnable task to an ExecutorService and returns a result of type Future: 
		 */

		Future<String> future = 
				executorService.submit(callableTask);

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		/**
		 * invokeAny() assigns a collection of tasks to an ExecutorService, \
		 * causing each to run, and returns the result of a successful execution of one task (if there was a successful execution):
		 */

		try {
			String result = executorService.invokeAny(callableTasks);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		/**
		 * invokeAll() assigns a collection of tasks to an ExecutorService, 
		 * causing each to run, and returns the result of all task executions in the form of a list of objects of type Future:
		 */


		try {
			List<Future<String>> futures = executorService.invokeAll(callableTasks);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
