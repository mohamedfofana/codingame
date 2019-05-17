package main.java.codingame;

import java.util.Arrays;

public class ClosestNumbersDistance {
	// Returns the distance between the two closest numbers.
    static int distClosestNumbers(int[] numbers) { 
        // try to implement it!
        Arrays.sort(numbers);        
        int closest = Integer.MAX_VALUE;
        for (int i=0 ; i<numbers.length-1; i++) {
            int currentDiff = numbers[i+1] - numbers[i];
            if (closest > currentDiff){
                closest = currentDiff;                
            }                            
        }
        return closest;
    }
    
    public static void main(String[] args) {
        int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
        int result = distClosestNumbers(testArray);
        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)
    }
}
