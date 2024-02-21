package main.java.leetcodepattern.arrays;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                if (Math.abs(hm.get(nums[i]) - i) <= k) {
                    return true;
                }
            }

            hm.put(nums[i], i);
        }

        return false;
    }
}