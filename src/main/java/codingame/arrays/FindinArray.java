package main.java.codingame.arrays;

import java.util.Arrays;

public class FindinArray {

	static boolean exists(int[] ints, int k) {
		if (ints.length == 0){
			return false;
		}
		//        int i = 0;
		//        while (i<=ints.length-1){
		//            if (ints[i] == k){
		//                return true;
		//            }
		//            i++;
		//        }
		if (Arrays.binarySearch(ints, k)>=0){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] ints = {-9, 14, 37, 102};
		System.out.println(exists(ints, 102)); // true
		System.out.println(exists(ints, 36)); // false
	}
}