package main.java.leetcodepattern.math;

import java.util.ArrayList;
import java.util.List;

public class The_kth_Factor_of_n {
    public int kthFactor(int n, int k) {
        List<Integer> l = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i != n) {
                    l.add(n / i);
                }

                if (--k == 0) {
                    return i;
                }
            }
        }

        if (l.size() < k) {
            return -1;
        }
        return l.get(l.size() - k);
    }
}
