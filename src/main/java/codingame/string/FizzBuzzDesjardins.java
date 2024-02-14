package main.java.codingame.string;

import java.util.Map;
import java.util.TreeMap;

public class FizzBuzzDesjardins {
	static String fizzbuzz(int number, Map<Integer, String> map) {
		StringBuilder result = new StringBuilder();
		for (Integer key : map.keySet()) {
			if(number % key ==0) {
				result.append(map.get(key));
			}
			
		}
		if(!result.toString().isEmpty()) {
			return result.toString();
		}
		
		return Integer.toString(number);
	}
	
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>();
		map.put(3, "FIZZ");
		map.put(4, "BUZZ");
		
		System.out.println(fizzbuzz(5,  map)); // "5"
		System.out.println(fizzbuzz(3,  map)); // "FIZZ"
		System.out.println(fizzbuzz(4,  map)); // "BUZZ"
		System.out.println(fizzbuzz(12,  map)); // "FIZZBUZZ"
	}
}
