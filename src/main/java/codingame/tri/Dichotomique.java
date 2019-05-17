package main.java.codingame.tri;

public class Dichotomique {
	
	public static int dichoSearch(int[] arr, int s) {
		return dichoSearchRecursif(arr, 0, arr.length, s);
	}
	
	public static int dichoSearchMemoization(int[] arr, int s) {
		return dichoSearchRecursifMemoization(arr, 0, arr.length, s, new int[arr.length+1]);
	}

	public static int dichoSearchRecursif(int[] arr, int deb, int fin, int s) {
		int mid = (deb + fin)/2;
		if (deb>fin || (deb == mid && arr[mid] !=s) || (fin == mid && arr[mid] !=s)) 
			return -1;
		else if (s == arr[mid])
			return mid;
		else if(s > arr[mid]) 
			return dichoSearchRecursif(arr, mid, fin, s);
		else if(s < arr[mid]) 
			return dichoSearchRecursif(arr, deb, mid, s);
		else
			return -1;
	}

	public static int dichoSearchRecursifMemoization(int[] arr, int deb, int fin, int s, int [] memo) {
		int mid = (deb + fin)/2;
		if (deb>fin || (deb == mid && arr[mid] !=s) || (fin == mid && arr[mid] !=s)) 
			memo[mid] =  -1;
		else if (s == arr[mid])
			memo[mid] = mid;
		else if (memo[mid] == 0){
			if(s > arr[mid]) 
				memo[mid] = dichoSearchRecursifMemoization(arr, mid, fin, s, memo);
			else if(s < arr[mid]) 
				memo[mid] = dichoSearchRecursifMemoization(arr, deb, mid, s, memo);
			else
				return memo[mid] = -1;
		}
		return memo[mid];
	}

}
