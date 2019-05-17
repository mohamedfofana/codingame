package main.java.codingame;

public class Fibonacci {

	static int fibonacciRecursif(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			return fibonacciRecursif(n-1) + fibonacciRecursif(n-2);
		}
	}
	
	static int fibonacciMemoization(int n, int[] memo) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (memo[n]!=0)
			return memo[n];
		else {
			memo[n] =fibonacciMemoization(n-1, memo) + fibonacciMemoization(n-2, memo);
			return memo[n];
		}
	}
	
	static int fibonacciIteratif(int n) {
		int fiboNmoinsNmoins2 = 0;
		int fiboNmoinsNmoins1 = 1;
		for (int i = 2; i<=n; i++) {
			int oldFiboNmoinsNmoins1 = fiboNmoinsNmoins1;
			fiboNmoinsNmoins1 = fiboNmoinsNmoins1 + fiboNmoinsNmoins2;
			fiboNmoinsNmoins2 = oldFiboNmoinsNmoins1;
		}
		return fiboNmoinsNmoins1;
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacciRecursif(10));
		System.out.println(fibonacciIteratif(10));
		int[] memo = new int[11];
		System.out.println(fibonacciMemoization(10, memo));
	}
}
