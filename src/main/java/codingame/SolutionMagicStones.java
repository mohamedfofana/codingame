package main.java.codingame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionMagicStones {
	static int nbStones = 0;
	
	static List<Integer> getRemainingStones( List<Integer> stones){
		List<Integer> newStones = new ArrayList<Integer>();
		if(stones.size()%2 != 0) {
			nbStones++;
			stones.remove(stones.size()-1);
		}
		int div = stones.size()/2; 
		Integer el = stones.get(0);
		for (int i = 0; i < div; i++) {
			newStones.add(el+1);
		}
		return newStones;
	}
	
	static int magic(List<Integer> stones) {
		Integer[] arr = new Integer[stones.size()];
		arr = stones.toArray(arr);
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			Integer cur = arr[i];
			List<Integer> newStones = new ArrayList<Integer>();
			while(i <arr.length && cur == arr[i]) {
				newStones.add(arr[i]);
				i++;
			}
			i--;
			if (newStones.size() == 1)
				nbStones++;
			if (i < arr.length && newStones.size()>1)
				stones.addAll(i, getRemainingStones(newStones));
			
				
		}
		return nbStones;
	}
	
	public static void main(String[] args) {
		List<Integer> stones = new ArrayList<Integer>(Arrays.asList(1,2,2,3,4));
		System.out.println(magic(stones));
	}

}
