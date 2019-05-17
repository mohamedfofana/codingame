package main.java.codingame;

public class Factorielle {

	static int factorielleRecursif(int n) {
		if (n == 1)
			return 1;
		else
			return n*factorielleRecursif(n-1);
	}
	
	static int factorielleIteratif(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact*=i;
		}
		return fact;
	}
	static int factorielleMemoization(int n, int[] memo) {
		if (n==0)
			return 1;
		if (memo[n]!=0)
			return memo[n];
		else {
			memo[n] = n * factorielleMemoization(n-1, memo);
			return memo[n];
		}
			
	}
	public static void main(String[] args) {
		System.out.println(factorielleRecursif(5));
		System.out.println(factorielleIteratif(5));
		int[] memo = new int[6];
		System.out.println(factorielleMemoization(5, memo));
	}
}
