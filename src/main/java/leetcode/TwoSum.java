package main.java.leetcode;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSumFast(int[] nums, int target) {
        var numsMap = new HashMap<Integer, Integer>();
        numsMap.put(target - nums[0], 0);
        for(int i =1; i < nums.length; i++) {
            var index = numsMap.get(nums[i]);
            if (index != null ) {
                return new int[] {index, i};
            }
            numsMap.put(target - nums[i], i);
        }
        return nums;
    }

    /**
     *  Solution 2
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        var numsMap = new HashMap<Integer, Integer>();
        for(int i =0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for(int i = 0; i< nums.length; i++) {
            var difference = target - nums[i];
            if(numsMap.containsKey(difference) && numsMap.get(difference) != i) {
                return new int[]{ i, numsMap.get(difference)};
            }
        }
        return nums;
    }
}
