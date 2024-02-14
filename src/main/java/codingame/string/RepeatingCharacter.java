package main.java.codingame.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RepeatingCharacter {
	 // This function prints the first repeated 
    // character in str[] 
    static char firstRepeating(char str[]){ 
        // Creates an empty hashset 
        HashSet<Character> h = new HashSet<>(); 
        // Traverse the input array from left to right 
        for (int i=0; i<=str.length-1; i++){ 
            char c = str[i]; 
            // If element is already in hash set, update x 
            // and then break 
            if (h.contains(c)) 
                return c; 
 
            else // Else add element to hash set 
                h.add(c); 
        } 
 
        return '\0'; 
    } 
 
    /**
     * Find maximum occurring character in a string
     * @param args
     */
    static Map<Character, Integer> findMaxCharacterCount(String str){
        // Initialize max with the first character and its count
        Map<Character, Integer> max = new HashMap<>();
        max.put(str.charAt(0), str.length() - str.replace(String.valueOf(str.charAt(0)), "").length());
 
        // Iterate through the string to find the character with the maximum count
        for (char i : str.toCharArray()) {
            int count = str.length() - str.replace(String.valueOf(i), "").length();
            if (count > max.get(max.keySet().iterator().next())) {
                // Update max if the count is higher
                max.clear();
                max.put(i, count);
            }
        }
 
        return max;
    }
    // Driver method to test above method 
    public static void main (String[] args){ 
        String str = "geeksforgeeks"; 
        char[] arr = str.toCharArray(); 
        System.out.println(firstRepeating(arr)); 
    } 
}
