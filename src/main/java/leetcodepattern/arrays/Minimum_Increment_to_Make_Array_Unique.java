package main.java.leetcodepattern.arrays;

import java.util.Arrays;

public class Minimum_Increment_to_Make_Array_Unique {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        int result = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                result += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }

        return result;
    }
}
