package main.java.codingame.number;

public class Fibonacci {

	public static int fibonacciRecursif(int n) {
		if (n <= 1)
			return n;
		else
			return fibonacciRecursif(n-1) + fibonacciRecursif(n-2);
	}
	
	public static int fibonacciMemoization(int n) {
		return fibonacciRecursifMemoization(n, new int[n+1]);
	}
	
	public static int fibonacciRecursifMemoization(int n, int[] memo) {
		if (n <= 1)
			return n;
		if (memo[n]!=0)
			return memo[n];
		else {
			memo[n] =fibonacciRecursifMemoization(n-1, memo) + fibonacciRecursifMemoization(n-2, memo);
			return memo[n];
		}
	}
	
	public static int fibonacciIteratif(int n) {
		int oldFibo = 0;
		int newFibo = 1;
		if (n <= 1)
			return n;
		for (int i = 2; i<=n; i++) {
			int tmpFibo = newFibo;
			newFibo = newFibo + oldFibo;
			oldFibo = tmpFibo;
		}
		return newFibo;
	}
	
}
