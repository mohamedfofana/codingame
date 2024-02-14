package main.java.multithreading;

/**
 * You cannot extend another class
 * You can only implement others classes
 * You have other method available (join, stop, resume, ...)
 */
public class MyMultithreadingClass extends Thread {
	
	private int threadNumber;
	
	public MyMultithreadingClass(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Printing " + i + " of thread " +threadNumber);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}	
	}
	
	public static void main(String[] args) {
		MyMultithreadingClass thread1 = new MyMultithreadingClass(1);
		MyMultithreadingClass thread2 = new MyMultithreadingClass(2);
		// Execute sequentially
//		thread.run();
//		thread2.run();
//		 Execute asynchronusly
		thread1.start();
		thread2.start();
		
		/**
		 * Wait for thread1 comppletion with join sequentially
		 */
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
		
	}
}
