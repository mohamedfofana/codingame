package main.java.leetcodepattern.modifiedBinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                --high;
            }
        }

        return nums[low];
    }
}
