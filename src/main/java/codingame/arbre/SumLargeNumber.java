package main.java.codingame.arbre;

import java.util.List;

public class SumLargeNumber {

	static int sumLargeNumberIteratif (List<Integer> numbers) {
		int sum = 0;
		for (int n : numbers) {
			sum += n;
		}

		return sum;
	}

	/**
	 * In this example, the parallelStream() method creates a parallel stream from the list of numbers. 
	 * The parallel processing can lead to a significant speedup in performance, especially for large collections of data.
	 * @param numbers
	 * @return
	 */
	static int sumLargeNumberStream (List<Integer> numbers) {
		int sum = numbers.parallelStream()
				.reduce(0, Integer::sum);

		return sum;
	}
}
