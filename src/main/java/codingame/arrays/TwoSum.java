package main.java.codingame.arrays;

import java.util.HashMap;
public class TwoSum {
	
	/**
	 * Given an absolute sorted array and a number K, find the pair whose sum is K
	 */
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
    
//    public static int[] twoSumNoDupOn(int[] arr, int sum){
//    	Map<Integer, Integer> map = new HashMap<>(arr.length);
//    	for (int i = 0; i < arr.length; i++) {
//    		int curSum = sum - arr[i];
//    		if (map.containsKey(curSum)){
//    			return new int[]{i, map.get(curSum)};
//    		}
//    		else{
//    			map.put(arr[i], i);
//    		}
//    	}
//    	return new int[]{};
//    }
//    public static int[] twoSumNoDupO2n(int[] arr, int sum){
//    	Map<Integer, Integer> map = new HashMap<>(arr.length);
//    	for (int i = 0; i < arr.length; i++) {
//    		map.put(arr[i], i);
//    	}
//    	for (int i = 0; i < arr.length; i++) {
//    		int curSum = sum - arr[i];
//    		if (map.containsKey(curSum)){
//    			return new int[]{i, map.get(curSum)};
//    		}
//    	}
//    	return new int[]{};
//    }
    public static int[] twoSumOn2(int[] arr, int sum){
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = i+1; j < arr.length; j++) {
    			if (arr[i] + arr[j] == sum){
    				return new int[]{i, j};
    			}
    		}
    	}
    	return new int[]{};
    }
}
