package main.java.leetcodepattern.dynamicprogramming;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int sold = 0, rest = 0, hold = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int prevSold = sold;

            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prevSold);
        }

        return Math.max(sold, rest);
    }
}
