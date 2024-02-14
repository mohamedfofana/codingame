package main.java.codingame.arrays;

public class SumLeftReverseRight {
	 // Function to reverse an integer
    static int reverseInteger(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }
 
    // Function to check if an index satisfies the condition
    static boolean checkIndex(int[] arr, int index) {
        int leftSum = 0;
        for (int i = 0; i < index; ++i) {
            leftSum += arr[i];
        }
 
        int rightSum = 0;
        for (int i = index + 1; i < arr.length; ++i) {
            rightSum += arr[i];
        }
 
        return leftSum == reverseInteger(rightSum);
    }
 
    // Function to find the index
    static int findIndex(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            totalSum += arr[i];
        }
 
        int leftSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            int rightSum = totalSum - leftSum - arr[i];
 
            if (leftSum == reverseInteger(rightSum)) {
                return i;
            }
            leftSum += arr[i];
        }
 
        return -1;
    }
 
    public static void main(String[] args) {
        int[] arr = {5, 7, 3, 6, 4, 9, 2};
        int index = findIndex(arr);
 
        // Output
        System.out.println(index);
    }
}
