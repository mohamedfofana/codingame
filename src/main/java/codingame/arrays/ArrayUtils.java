package main.java.codingame.arrays;

import java.util.Random;

public class ArrayUtils {
	static Random random = new Random();
	
	public static int[] getRandomArray(int size, int min, int max) {
		int[] arr = new int[size];
		for (int i = 0; i< size; i++) {
			arr[i] = random.ints(min,max+1).findFirst().getAsInt();
		}
		return arr;
	}
}
