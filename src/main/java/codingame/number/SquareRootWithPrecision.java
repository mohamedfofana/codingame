package main.java.codingame.number;

public class SquareRootWithPrecision {
	/**
	 * Given a positive number n and precision p, find the square root of number upto p decimal places using binary search. 
	Note : Prerequisite : Binary search 
	Examples: 


	Input : number = 50, precision = 3
	Output : 7.071

	Input : number = 10, precision = 4
	Output : 3.1622

	 */

	// Function to find square root
	// of given number upto given
	// precision
	static float squareRoot(int number, int precision){
		int start = 0, end = number;
		int mid;
		// variable to store the answer
		double ans = 0.0;
		// for computing integral part // of square root of number
		while (start <= end) {
			mid = (start + end) / 2;
			if (mid * mid == number) {
				ans = mid;
				break;
			}
			// incrementing start if integral // part lies on right side of the mid
			if (mid * mid < number) {
				start = mid + 1;
				ans = mid;
			}
			// decrementing end if integral part // lies on the left side of the mid
			else {
				end = mid - 1;
			}
		}
		// For computing the fractional part // of square root upto given precision
		double increment = 0.1;
		for (int i = 0; i < precision; i++) {
			while (ans * ans <= number) {
				ans += increment;
			}
			// loop terminates when ans * ans > number
			ans = ans - increment;
			increment = increment / 10;
		}
		return (float)ans;
	}

	// Driver code
	public static void main(String[] args){
		// Function calling
		System.out.println(squareRoot(50, 3));

		// Function calling
		System.out.println(squareRoot(10, 4));
	}
}
