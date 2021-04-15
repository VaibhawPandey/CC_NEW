package main.java.Leetcode.DP.Medium;

import java.util.Arrays;

public class MinFallingPathSum {
    public static void main(String[] args) {
        System.out.println(new MinFallingPathSum().minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    public int minFallingPathSum(int[][] A) {

        int m = A.length;

        if (m == 0)
            return 0;

        int n = A[0].length;
        int dp[][] = new int[m][n];
//        for (int i = 1; i < m; i++)
//            Arrays.fill(dp[i], Integer.MAX_VALUE);

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    dp[i][j] = A[i][j];
                else
                    dp[i][j] = A[i][j] + Math.min(getValue(i-1, j-1, m, n, dp), Math.min(getValue(i-1, j, m, n, dp),getValue(i-1, j+1, m, n, dp)));

                if (i == m - 1) res = Math.min(res, dp[i][j]);
            }
        }

        return res;
    }

    private int getValue(int i, int j, int m, int n, int[][] dp) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return Integer.MAX_VALUE;

        return dp[i][j];
    }
}
