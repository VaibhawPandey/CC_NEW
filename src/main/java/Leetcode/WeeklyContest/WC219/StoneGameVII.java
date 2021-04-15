package main.java.Leetcode.WeeklyContest.WC219;

public class StoneGameVII {
    public static void main(String[] args) {
        new StoneGameVII().stoneGameVII(new int[]{5, 3, 1, 4, 2});
    }
    public int stoneGameVII(int[] stones) {

        int n = stones.length;
        int dp[][][] = new int[n][n][2];

        int prefixSum[] = new int[n];
        int suffixSum[] = new int[n];

        for (int i = n-2; i >= 0; i--)
            suffixSum[i] = suffixSum[i+1] + stones[i+1];

        for (int i = 0; i < n; i++) {
            if (i >= 1)
                prefixSum[i] = prefixSum[i-1] + stones[i-1];

            dp[i][i][0] = stones[i];
            dp[i][i][1] = 0;
        }

        int k = n - 1;

        while (k > 0) {

            int i = 0, j = n - k;

            while (i < n && j < n) {

                dp[i][j][0] = Math.max(dp[i+1][j][1] + suffixSum[i], dp[i][j-1][1] + prefixSum[j]);

                if (dp[i][j][0] == dp[i+1][j][1] + suffixSum[i]) {
                    dp[i][j][1] = dp[i+1][j][0];
                } else {
                    dp[i][j][1] = dp[i][j-1][0];
                }

                i++;j++;
            }

            k--;
        }


        return dp[0][n-1][0] - dp[0][n-1][1];
    }
}
