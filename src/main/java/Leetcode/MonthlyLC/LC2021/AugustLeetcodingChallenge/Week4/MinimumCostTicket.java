package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week4;

public class MinimumCostTicket {

    public static void main(String[] args) {
        new MinimumCostTicket().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
    }

    public int mincostTickets(int[] days, int[] costs) {

        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];

        boolean isExist[] = new boolean[lastDay + 1];

        for (int i = 0; i < days.length; i++)
            isExist[days[i]] = true;

        for (int i = 1; i <= lastDay; i++) {

            if (!isExist[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }

        return dp[lastDay];
    }
}
