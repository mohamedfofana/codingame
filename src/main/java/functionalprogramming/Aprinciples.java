package main.java.functionalprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Pure Functions
 * A function is called pure function if it always returns the same result for same argument values 
 * and it has no side effects like modifying an argument (or global variable) or outputting something. 
 */
public class Aprinciples {
	/**
	 * Higher-order functions: In functional programming, functions are to be considered as first-class citizens. That is, so far in the legacy style of coding, we can do below stuff with objects. 
We can pass objects to a function.
We can create objects within function.
We can return objects from a function.
We can pass a function to a function.
We can create a function within function.
We can return a function from a function.
Pure functions: A function is called pure function if it always returns the same result for same argument values and it has no side effects like modifying an argument (or global variable) or outputting something.
Lambda expressions: A Lambda expression is an anonymous method that has mutability at very minimum and it has only a parameter list and a body. The return type is always inferred based on the context. Also, make a note, Lambda expressions work in parallel with the functional interface. The syntax of a lambda expression is: 
	 */

	static void runnableExample() {
		// Defining an anonymous method
		Runnable r = new Runnable() {
			public void run()
			{
				System.out.println(
						"Running in Runnable thread");
			}
		};

		r.run();
		System.out.println(
				"Running in main thread");
	}

	static void countStream() {
		List<Integer> numbers = Arrays.asList(11, 22, 33, 44,
				55, 66, 77, 88,
				99, 100);

		System.out.println(numbers.stream()
								  .filter(number -> number % 2 == 0)
								  .mapToInt(e -> e * 2)
								  .sum());
	}
	
	public static void main(String[] args) {
		runnableExample();
		countStream();
	}
}
