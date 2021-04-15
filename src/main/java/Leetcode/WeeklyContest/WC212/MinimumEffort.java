package main.java.Leetcode.WeeklyContest.WC212;

import java.util.Arrays;

public class MinimumEffort {
    public static void main(String[] args) {
        System.out.println(new MinimumEffort().minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
    }
    // int res = Integer.MAX_VALUE;
    boolean visited[][];
    int dp[][];
    public int minimumEffortPath(int[][] heights) {

        int r = heights.length - 1;
        int c = heights[0].length - 1;
        int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        dp = new int[r + 1][c + 1];
        visited = new boolean[r + 1][c + 1];
        for (int i = 0; i <= r; i++)
           Arrays.fill(dp[i], Integer.MAX_VALUE);

        return solve(heights, r, c, 0, r, c, direction);
        // return res;
    }

    private int solve(int[][] heights, int i, int j, int effort, int r, int c, int[][] direction) {

        if (i == 0 && j == 0) {
            // res = Math.min(res, effort);
            return effort;
        }

        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

         visited[i][j] = true;

         int res = Integer.MAX_VALUE;

        for (int k = 0; k < direction.length; k++) {

            int hi = i + direction[k][0], hj = j + direction[k][1];
            if (isValid(hi, hj, r, c) && !visited[hi][hj]) {
                res = Math.min(solve(heights, hi, hj, Math.max(effort, Math.abs(heights[hi][hj] - heights[i][j])), r, c, direction), res);
            }
        }
        // return dp[i][j];
        visited[i][j] = false;
        return dp[i][j] = res;
    }

    private boolean isValid(int i, int j, int r, int c) {

        if (i < 0 || i > r || j < 0 || j > c)
            return false;

        return true;
    }

}
