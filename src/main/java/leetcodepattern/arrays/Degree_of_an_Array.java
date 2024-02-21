package main.java.leetcodepattern.arrays;

import java.util.HashMap;
import java.util.Map;

public class Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> indexes = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        int result = 0, maxFrequency = 0;

        for (int i = 0; i < nums.length; i++) {
            indexes.putIfAbsent(nums[i], i);
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);

            if (frequency.get(nums[i]) > maxFrequency) {
                maxFrequency = frequency.get(nums[i]);
                result = i - indexes.get(nums[i]) + 1;
            } else if (frequency.get(nums[i]) == maxFrequency) {
                result = Math.min(result, i - indexes.get(nums[i]) + 1);
            }
        }

        return result;
    }
}
