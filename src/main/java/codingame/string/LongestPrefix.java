package main.java.codingame.string;

import java.util.Arrays;

public class LongestPrefix {
/**
 * Problem Statement: Given a set of strings, find the longest common prefix.
	Examples:
	
	Input: {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
	Output: “gee”
	
	Input: {“apple”, “ape”, “april”}
	Output: “ap”
	
	The longest common prefix for an array of strings is the common prefix between 2 most dissimilar strings. 
	For example, in the given array {“apple”, “ape”, “zebra”}, 
	there is no common prefix because the 2 most dissimilar strings of the array “ape” and “zebra” do not share any starting characters. 
	We have discussed five different approaches below posts. 
*/
	
	static String longestCommonPrefix(String arr[]) {
		final int size = arr.length;
		if (size == 1){
			return arr[0];
		}
		if (size > 1){
			Arrays.sort(arr);
			int length = arr[0].length();
			StringBuilder res = new StringBuilder();
			// Comapre the first and the last strings character
			// by character.
			// It's not longer than the smallest
			// It should be 
			for(int i = 0; i < length; i++){
				// If the characters match, append the character to the result.
				if(arr[0].charAt(i) == arr[size - 1].charAt(i)){
					res.append(arr[0].charAt(i));
				}
				// Else, stop the comparison.
				else{
					return res.toString();
				}
			}
		}
		
		return "";
	}
	
	public static void main(String args[]) {
        String[] arr = {"mint", "mini", "mineral"};
        // The longest common prefix of an empty array is "".
        System.out.println("Longest common prefix: " + longestCommonPrefix(arr));
    }
}
