package main.java.Practice.DP.LCS;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abdfg", "abthj"));
    }

    public static int longestCommonSubstring(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else
                    dp[i][j] = 0;

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
