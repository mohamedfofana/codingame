package main.java.codingame.arrays;

import java.util.HashMap;
import java.util.Map;

public class OccurencesIntInArray {
    // Returns number of times x occurs in arr[0..n-1] 
    static int countOccurrences(int arr[], int n, int x) { 
        int res = 0; 
        for (int i=0; i<n; i++) 
            if (x == arr[i]) 
              res++; 
        return res; 
    } 
      
    public static void main(String args[]) 
    { 
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 }; 
        int n = arr.length; 
        int x = 2;
        Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
        for (int i : arr) {
        		map.put(i, countOccurrences(arr, n, i)); 			
       }
        System.out.println(map);
    } 
}
