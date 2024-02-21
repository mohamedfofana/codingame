package main.java.leetcodepattern.bitwiseOperations;

public class Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            int xor = a ^ b;

            a = xor;
            b = carry << 1;
        }

        return a;
    }
}
