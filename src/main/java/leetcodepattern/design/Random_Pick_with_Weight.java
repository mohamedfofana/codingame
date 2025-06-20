package main.java.leetcodepattern.design;

public class Random_Pick_with_Weight {
    int[] prefix;
    int totalSum;

    public Random_Pick_with_Weight(int[] w) {
        prefix = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefix[i] = totalSum;
        }
    }

    public int pickIndex() {
        int low = 0, high = prefix.length - 1;
        double target = totalSum * Math.random();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (prefix[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
