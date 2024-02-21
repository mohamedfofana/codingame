package main.java.leetcodepattern.dynamicprogramming;

public class Count_Numbers_with_Unique_Digits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 10, base = 9;

        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            result += base;
        }

        return result;
    }
}
