package main.java.leetcodepattern.topKElements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Course_Schedule_III {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        if (n == 0)
            return 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int start = 0;
        for (int[] course : courses) {
            start += course[0];
            pq.offer(course[0]);
            if (start > course[1]) {
                start -= pq.poll();
            }
        }
        return pq.size();
    }
}
