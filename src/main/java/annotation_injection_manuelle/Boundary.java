package main.java.annotation_injection_manuelle;

import java.util.Arrays;

public class Boundary {
	int test = 0;

	static boolean exists(int[] ints, int k) {
		Arrays.sort(ints);
		if (Arrays.binarySearch(ints, k) >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] ints = { -9, 14, 37, 102 };
		Boundary b = new Boundary();
		b.test = 1;
//		String s= 
//		if 
//		System.out.println(Boundary.exists(ints, 102)); // true
//		System.out.println(Boundary.exists(ints, 36)); // false
	}
}
