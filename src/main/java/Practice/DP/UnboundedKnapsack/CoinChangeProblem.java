package main.java.Practice.DP.UnboundedKnapsack;

public class CoinChangeProblem {
    public static void main(String[] args) {
        System.out.println(maxWays(new int[]{2, 3, 4}, 12));
    }

    // Maximum number of ways to get a sum
    public static int maxWays(int coins[], int sum) {

        int dp[][] = new int[coins.length + 1][sum + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (i == 0)
                    continue;

                if (j >= coins[i-1])
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[coins.length][sum];
    }

    // Minimum coins required to form a sum
    public static int minimumCoin(int coins[], int sum) {

        int dp[][] = new int[coins.length + 1][sum + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0)
                    continue;

                if (i == 0){
                    dp[i][j] = Integer.MAX_VALUE - 1;
                    continue;
                }

                if (i == 1) {
                    dp[i][j] = j/coins[i-1];
                    continue;
                }

                if (j >= coins[i-1]) {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i-1][j - coins[i-1]]);
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[coins.length][sum];
    }
}
