package main.java.codingame.arrays;

public class RemoveDuplicates {

	/**
	 * Remove duplicates from Sorted Array
	 * Given a sorted array arr[] of size N, the task is to remove the duplicate elements from the array.
	Examples: 
	Input: arr[] = {2, 2, 2, 2, 2}
	Output: arr[] = {2}
	Explanation: All the elements are 2, So only keep one instance of 2.
	Input: arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}
	Output: arr[] = {1, 2, 3, 4, 5}

	 */
	// Function to remove duplicate elements
    // This function returns new size of modified
    // array.
    static int removeDuplicates(int arr[], int n){
        if (n == 0 || n == 1)
            return n;
        // To store index of next unique element
        int j = 0;
        // Doing same as done in Method 1
        // Just maintaining another updated index i.e. j
        for (int i = 0; i < n-1; i++)
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];
      
        arr[j++] = arr[n-1];
      
        return j;
    }
     
    /**
     * Fastest Efficient Approach: Using Binary Search
     * @param args
     */
    // Function to remove duplicate elements
    // This function returns new size of modified array.
    // Using Binary Search to solve the particular problem efficiently
//    Time Complexity: O(N) , in the worst case we will traverse whole array when each element of array is unique.
//    Auxiliary Space: O(1),No extra space is used
    static int binarySearch(int[] nums, int low, int high, int val) {
        int n = nums.length;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check for lower limit
            if (nums[mid] <= val)
                low = mid + 1;
            // Check for higher limit
            else {
                // Move to higher limit
                res = mid;
                high = mid - 1;
            }
        }
        // Check if not found
        if (res == -1)
            return n;
 
        return res;
    }
 
    static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int idx = 0; // It store indexing of unique elements.
 
        while (idx != n) {
            int i = binarySearch(nums, idx + 1, n - 1, nums[idx]); // It finds upper bound of element.
 
            if (i == n)
                return idx + 1; // Means that we are not able to find the upper bound of the element.
            idx++;
            nums[idx] = nums[i];
        }
        return idx + 1;
    }
    
    public static void main (String[] args){
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;
         
        n = removeDuplicates(arr, n);
  
        // Print updated array
        for (int i=0; i<n; i++)
           System.out.print(arr[i]+" ");
    }
}
