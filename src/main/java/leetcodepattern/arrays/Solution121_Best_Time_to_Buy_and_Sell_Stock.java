package main.java.leetcodepattern.arrays;
public class Solution121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrices = prices[0], profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            }
            profit = Math.max(profit, prices[i] - minPrices);
        }

        return profit;
    }
}
