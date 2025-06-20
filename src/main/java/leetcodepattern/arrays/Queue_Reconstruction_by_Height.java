package main.java.leetcodepattern.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[][] {};
        }

        List<int[]> result = new ArrayList<>();

        Arrays.sort(people, (p1, p2) -> p2[0] == p1[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][]);
    }
}
