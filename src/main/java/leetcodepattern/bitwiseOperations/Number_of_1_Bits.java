package main.java.leetcodepattern.bitwiseOperations;

public class Number_of_1_Bits {
    public int hammingWeight(int n) {
        int total = 0;

        for (int i = 0; i < 32; i++) {
            total += (n & 1);
            n = n >> 1;
        }

        return total;
    }
}
