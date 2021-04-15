package main.java.Practice.DP.UnboundedKnapsack;

public class RodCutting {
    public static void main(String[] args) {

        System.out.println(new RodCutting().rodCutting(new int[]{1, 2, 3, 4}, new int[]{5, 1, 4, 2}, 4));
    }

    // Max cost
    public int rodCutting(int length[], int cost[], int lengthofRod) {

        int dp[][] = new int[length.length + 1][lengthofRod + 1];

        for (int i = 1; i <= length.length; i++) {
            for (int j = 1; j <= lengthofRod; j++) {
                if (j >= length[i-1]) {
                    dp[i][j] = Math.max(cost[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[length.length][lengthofRod];
    }
}
