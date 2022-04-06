package main.java.Leetcode.MonthlyLC.LC2021.JulyLeetcodingChallenge.Week5;

public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {

        int rest = 0, sold = 0, hold = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {

            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, sold);
            sold = hold + prices[i];

        }

        return Math.max(rest, sold);
    }
}
