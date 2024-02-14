package main.java.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture provides a powerful and flexible way to write asynchronous, non-blocking code. 
 * It was introduced in Java 8
 * It has become popular due to its ease of use and ability to handle complex asynchronous workflows
 * CompletableFuture is a class in java.util.concurrent package that implements the Future and CompletionStage Interface. 
 */
public class CompletableFutureMy {

	/**
	 * To create an instance of CompletableFuture, 
	 * we can use the static method supplyAsync provided by CompletableFuture class which takes Supplier as an argument. 
	 * Supplier is a Functional Interface that takes no value and returns a result.
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */

	static void supplyAsync()  throws InterruptedException, ExecutionException{
		CompletableFuture<String> greetingFuture = CompletableFuture.supplyAsync(() -> { 
			// some async computation 
			return "Hello from CompletableFuture"; 
		}); 

		System.out.println(greetingFuture.get());
	}

	/**
	 * Composing CompletableFuture
	 * One of the powerful features of CompletableFuture is its ability to compose multiple asynchronous operations. 
	 * We can use methods like thenApply, thenCombine, thenCompose 
	 * to perform operations on the result of one CompletableFuture and create a new CompletableFuture as a result.
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	static void composingCompletableFuture() throws InterruptedException, ExecutionException {
		CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> "Hello"); 
		CompletableFuture<String> greetingFuture  = CompletableFuture.supplyAsync(() -> "World"); 

		/**
		 * thenCombine: This method is used when both processes (CompletableFuture) can work independently and once both are done 
		 * their results can be combined to get the final result.
		 */
		CompletableFuture<String> combinedFuture  = helloFuture.thenCombine(greetingFuture, (m1, m2) -> m1 + " " + m2); 
		
		/**
		 * thenApply: This method is more or less same and thenCompose only difference 
		 * it it will return the result instead of another CompletableFuture in its Lambda.
		 */
		CompletableFuture<String> appliedFuture  = helloFuture.thenApply((m1) -> m1 + " World"); 
		
		/**
		 * thenCompose: This method is used 
		 * when one CompletableFuture is waiting for another CompletableFuture to provide its result. 
		 * Once it is available result will be processed asynchronously
		 */
		CompletableFuture<String> composeFuture  = helloFuture
													.thenCompose( m1 -> {
														return CompletableFuture.supplyAsync(() -> m1 + " World");
													}); 

		System.out.println(combinedFuture.get()); 
		System.out.println(appliedFuture.get()); 
		System.out.println(composeFuture.get()); 
	}

	/**
	 * Handling Exception in CompletableFuture
     * CompletableFuture provides methods like exceptionally and handle to handle exceptions 
     * and errors that might happen during asynchronous computation 
     * and provide a fallback value or perform some alternative operation.
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	
	static void handleException() throws InterruptedException, ExecutionException {
		   // java.lang.ArithmeticException: / by zero 
		 CompletableFuture<Integer> resultFuture = CompletableFuture.supplyAsync(() -> 10 / 0)   
                     .exceptionally(ex -> 0); 
       
         // 0 - returned by exceptionally block 
       System.out.println(resultFuture.get()); 
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		supplyAsync();
		composingCompletableFuture();
		composingCompletableFuture();
	}
}
