package main.java.leetcodepattern.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {
        // If same height, sort by idx ascending, otherwise sort by height descending
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][]);
    }
}
