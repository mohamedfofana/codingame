package main.java.codingame.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays and our task is to find their common elements. 
 */
public class CommonElementsInTwoArrays {

	static List<Integer> findCommonElements(int[] arr1, int[] arr2){
		if(arr1.length > arr2.length) {
			Arrays.sort(arr1);
			return commonElements(arr1, arr2);
		}
		Arrays.sort(arr2);
		
		return commonElements(arr2, arr1);
	}
	
	static List<Integer> commonElements(int[] bigArray, int[] smallArray){
		List<Integer>  result = new ArrayList<>();
		for (int i = 0; i < smallArray.length; i++) {
			final int recurrence = Arrays.binarySearch(bigArray, smallArray[i]);
			System.out.println(recurrence);
			if(recurrence >= 0) {
				result.add(smallArray[i]);
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(findCommonElements(new int[] {7, 8, 10, 25}, new int[] {2, 9, 7, 47, 39, 10}));
	}
	
}
