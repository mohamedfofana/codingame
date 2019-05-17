package main.java.codingame.tri;

import java.time.Instant;
import java.util.Arrays;

import main.java.codingame.arrays.ArrayUtils;

public class TriTest {
	public static void main(String[] args) {
		int size = 1000;
		int min = 1;
		int max = size;
		int[] arr = new int[size];
		arr = ArrayUtils.getRandomArray(size, min, max);
		int[] copy = Arrays.copyOf(arr, size);
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		
		// Tri selection
		System.out.println("\nTri Selection Θ(n²)");
		long lStartTime = Instant.now().toEpochMilli();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					int tmp = arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
					
			}
		}
		long output = Instant.now().toEpochMilli() - lStartTime;
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println("\nDurée : " + output + " ms");
		arr = copy;
		// Arrays.sort 
		System.out.println("Arrays.sort == Θ(n log n)");
		lStartTime = Instant.now().toEpochMilli();
		Arrays.sort(arr);
		output = Instant.now().toEpochMilli() - lStartTime;
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println("\nDurée : " + output + " ms");
		arr = copy;
		// QuickSort
		System.out.println("QuickSort Θ(n log n)");
		QuickSort quickSort = new QuickSort();
		lStartTime = Instant.now().toEpochMilli();
		quickSort.sort(arr);
		output = Instant.now().toEpochMilli() - lStartTime;
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println("\nDurée : " + output + " ms");
		
	}

}
