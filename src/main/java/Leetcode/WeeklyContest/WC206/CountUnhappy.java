package main.java.Leetcode.WeeklyContest.WC206;

public class CountUnhappy {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        int dp[][] = new int[n][n];
        int pp[] = new int[n];
        int res = 0;

        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++)
                dp[i][preferences[i][j]] = j;
        }

        for (int p[]: pairs) {
            pp[p[0]] = p[1];
            pp[p[1]] = p[0];
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++)
                if (i != j && pp[i] != j) {
                    int x = pp[i], y = pp[j];

                    if (dp[i][j] < dp[i][x] && dp[j][i] < dp[j][y])
                        count = 1;
                }
            res += count;
        }

        return res;
    }
}
