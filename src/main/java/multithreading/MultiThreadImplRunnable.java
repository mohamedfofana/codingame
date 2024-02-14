package main.java.multithreading;

/**
 * You have only the run method to override
 * You can implement other Interface
 * You can extend another class
 */
public class MultiThreadImplRunnable implements Runnable {

	private int threadNumber;
	
	public MultiThreadImplRunnable(int threadNumber) {
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
		MultiThreadImplRunnable implRunnable1 = new MultiThreadImplRunnable(1);
		MultiThreadImplRunnable implRunnable2 = new MultiThreadImplRunnable(2);
		Thread thread1 = new Thread(implRunnable1);
		Thread thread2 = new Thread(implRunnable2);
		// Execute sequentially
//		thread.run();
//		thread2.run();
//		 Execute asynchronusly
//		thread1.start();
//		thread2.start();
		
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
		/** 
		 * Method avec Lambda
		 */
		Runnable runnable = () -> {
				for (int i = 1; i <= 5; i++) {
					System.out.println("Printing " + i + " of thread " + 3);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
		};
		Thread thread3 = new Thread(runnable);
		thread3.start();
	}
}
