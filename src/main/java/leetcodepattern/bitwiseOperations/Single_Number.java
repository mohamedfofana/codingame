package main.java.leetcodepattern.bitwiseOperations;

public class Single_Number {
    public int singleNumber(int[] nums) {
        int unique = 0;
        for (Integer n : nums) {
            unique ^= n;
        }
        return unique;
    }
}
