package main.java.codingame.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicates {

	/**
	 * Time Complexity: O(N) 
		Auxiliary Space: O(N)

		Efficient Approach: Use unordered_map for hashing. Count frequency of occurrence of each element and the elements with frequency more than 1 is printed. unordered_map is used as range of integers is not known. For Python, Use Dictionary to store number as key and it’s frequency as value. Dictionary can be used as range of integers is not known.
		
		Below is the implementation of the above approach:
	 * @param arr
	 * @param n
	 */
	// function to find and print duplicates 
	private static void printDuplicatesFast(int[] arr, int n){ 
		Map<Integer,Integer> map = new HashMap<>(); 
		int count = 0; 
		boolean dup = false; 
		for(int i = 0; i < n; i++){ 
			if(map.containsKey(arr[i])){ 
				count = map.get(arr[i]); 
				map.put(arr[i], count + 1); 
			} 
			else{ 
				map.put(arr[i], 1); 
			} 
		} 

		for(Entry<Integer,Integer> entry : map.entrySet()){ 
			// if frequency is more than 1 
			// print the element 
			if(entry.getValue() > 1){ 
				System.out.print(entry.getKey()+ " "); 
				dup = true; 
			} 
		} 
		// no duplicates present 
		if(!dup){ 
			System.out.println("-1"); 
		} 
	} 

	/**
	 * Another Efficient Approach(Space optimization):            

	First we will sort the array for binary search function.
	we will find index at which arr[i] occur first time lower_bound 
	Then , we will find index at which arr[i] occur last time upper_bound            
	Then check if diff=(last_index-first_index+1)>1         
	If diff >1 means it occurs more than once and print                         
	 Below is the implementation of the above approach:
	 Time Complexity: O(N)
	Auxiliary Space: O(1)   
	 * @param arr
	 * @param target
	 * @return
	 */
	// Function to find lower bound of target in arr 
	public static int lowerBound(int[] arr, int target) 
	{ 
		int lo = 0, hi = arr.length - 1; 
		int ans = -1; 
		while (lo <= hi) { 
			int mid = lo + (hi - lo) / 2; 
			if (arr[mid] >= target) { 
				ans = mid; 
				hi = mid - 1; 
			} 
			else { 
				lo = mid + 1; 
			} 
		} 
		return ans; 
	} 

	// Function to find upper bound of target in arr 
	public static int upperBound(int[] arr, int target) 
	{ 
		int lo = 0, hi = arr.length - 1; 
		int ans = -1; 
		while (lo <= hi) { 
			int mid = lo + (hi - lo) / 2; 
			if (arr[mid] <= target) { 
				ans = mid; 
				lo = mid + 1; 
			} 
			else { 
				hi = mid - 1; 
			} 
		} 
		return ans; 
	} 

	// Function to print elements that occur more than once 
	// in arr 
	static void printDuplicates(int[] arr, int n) 
	{ 
		Arrays.sort(arr); // sort array for binary search 

		System.out.print("["); 
		for (int i = 0; i < n; i++) { 
			// index of first and last occ of arr[i] 
			int firstIndex = lowerBound(arr, arr[i]); 
			int lastIndex = upperBound(arr, arr[i]); 

			int occurTime = lastIndex - firstIndex 
					+ 1; // frequency of arr[i] 

			if (occurTime 
					> 1) { // elements that occur more than 1 
				i = lastIndex; // update i to last_index 
				System.out.print(arr[i] + ", "); 
			} 
		} 
		System.out.println("]"); 
	} 

}
