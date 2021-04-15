package main.java.Leetcode.DP.Medium;

public class StoneGame {
    public static void main(String[] args) {
        new StoneGame().stoneGame(new int[]{2, 7, 9, 4, 4});
    }
    public boolean stoneGame(int[] piles) {

        int dp[][][] = new int[piles.length][piles.length][2];

        for (int i = 0; i < piles.length; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        int k = piles.length-1;

        while (k > 0) {
            int i = 0, j = piles.length - k;

            while (i < piles.length && j < piles.length) {

                dp[i][j][0] = Math.max(dp[i+1][j][1] + piles[i], dp[i][j-1][1] + piles[j]);

                if (dp[i][j][0] == dp[i+1][j][1] + piles[i]) {
                    dp[i][j][1] = dp[i+1][j][0];
                } else {
                    dp[i][j][1] = dp[i][j-1][0];
                }

                i++;j++;

            }
            k--;
        }

        return dp[0][piles.length - 1][0] > dp[0][piles.length - 1][1];
    }
}
