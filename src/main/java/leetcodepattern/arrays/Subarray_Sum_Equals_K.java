package main.java.leetcodepattern.arrays;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0, currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            currSum += num;

            if (map.containsKey(currSum - k)) {
                result += map.get(currSum - k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return result;
    }
}
