package main.java.leetcodepattern.modifiedBinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return Collections.emptyList();
        }

        int low = 0, high = arr.length - k;
        List<Integer> result = new ArrayList<>();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
